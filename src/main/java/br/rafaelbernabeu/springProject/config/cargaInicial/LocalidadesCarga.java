package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.localidades.Estado;
import br.rafaelbernabeu.springProject.entity.localidades.Mesorregiao;
import br.rafaelbernabeu.springProject.entity.localidades.Microrregiao;
import br.rafaelbernabeu.springProject.entity.localidades.Municipio;
import br.rafaelbernabeu.springProject.entity.localidades.Regiao;
import br.rafaelbernabeu.springProject.service.localidades.EstadoService;
import br.rafaelbernabeu.springProject.service.localidades.MesorregiaoService;
import br.rafaelbernabeu.springProject.service.localidades.MicrorregiaoService;
import br.rafaelbernabeu.springProject.service.localidades.MunicipioService;
import br.rafaelbernabeu.springProject.service.localidades.RegiaoService;
import br.rafaelbernabeu.springProject.util.ForkJoinTaskUtil;
import br.rafaelbernabeu.springProject.util.IBGEServiceUtil;
import br.rafaelbernabeu.springProject.util.URLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LocalidadesCarga implements Callable<Boolean> {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MesorregiaoService mesorregiaoService;

    @Autowired
    private MicrorregiaoService microrregiaoService;

    @Autowired
    private RegiaoService regiaoService;

    private List<Municipio> loadFromUrl() throws IOException {
        return URLUtil.fetchAndParseList(IBGEServiceUtil.URL_SERVICE_MUNICIPIOS, Municipio.class);
    }

    private void save(List<Municipio> municipios) {
        long tempoInicial = System.currentTimeMillis();

        Set<Microrregiao> microrregiaos = municipios.stream().map(Municipio::getMicrorregiao).collect(Collectors.toSet());
        Set<Mesorregiao> mesorregiaos = municipios.stream().map(m -> m.getMicrorregiao().getMesorregiao()).collect(Collectors.toSet());
        Set<Estado> estados = municipios.stream().map(m -> m.getMicrorregiao().getMesorregiao().getUf()).collect(Collectors.toSet());
        Set<Regiao> regiaos = municipios.stream().map(m -> m.getMicrorregiao().getMesorregiao().getUf().getRegiao()).collect(Collectors.toSet());

        ForkJoinTaskUtil<Regiao> taskRegiao = new ForkJoinTaskUtil<>(regiaos, regiaoService::salvar);
        ForkJoinTaskUtil<Estado> taskEstado = new ForkJoinTaskUtil<>(estados, estadoService::salvar);
        ForkJoinTaskUtil<Mesorregiao> taskMesorregiao = new ForkJoinTaskUtil<>(mesorregiaos, mesorregiaoService::salvar);
        ForkJoinTaskUtil<Microrregiao> taskMicrorregiao = new ForkJoinTaskUtil<>(microrregiaos, microrregiaoService::salvar);
        ForkJoinTaskUtil<Municipio> taskMunicipio = new ForkJoinTaskUtil<>(municipios, municipioService::salvar);

        try {
            Collection<Regiao> result1 = taskRegiao.start();
            Collection<Estado> result2 = taskEstado.start();
            Collection<Mesorregiao> result3 = taskMesorregiao.start();
            Collection<Microrregiao> result4 = taskMicrorregiao.start();
            Collection<Municipio> result5 = taskMunicipio.start();
        } catch (Exception e) {
            taskRegiao.cancel();
            taskEstado.cancel();
            taskMesorregiao.cancel();
            taskMicrorregiao.cancel();
            taskMunicipio.cancel();
            e.printStackTrace();
        }

        System.out.println((System.currentTimeMillis() - tempoInicial));
    }

    public void setup() throws IOException {
        save(loadFromUrl());
    }

    @Override
    public Boolean call() throws Exception {
        try {
            setup();
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
