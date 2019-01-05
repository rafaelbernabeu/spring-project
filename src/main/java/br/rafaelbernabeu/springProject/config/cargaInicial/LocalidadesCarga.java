package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.localidades.Municipio;
import br.rafaelbernabeu.springProject.service.localidades.EstadoService;
import br.rafaelbernabeu.springProject.service.localidades.MunicipioService;
import br.rafaelbernabeu.springProject.util.ForkJoinTaskUtil;
import br.rafaelbernabeu.springProject.util.IBGEServiceUtil;
import br.rafaelbernabeu.springProject.util.URLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@Service
public class LocalidadesCarga implements Callable<Boolean> {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioService municipioService;

    private void loadFromUrl() throws IOException {
        List<Municipio> municipios = URLUtil.fetchAndParseList(IBGEServiceUtil.URL_SERVICE_MUNICIPIOS, Municipio.class);
        ForkJoinTaskUtil<Municipio> taskUtil = new ForkJoinTaskUtil<>(municipios, municipioService::salvar);
        long tempoInicial = System.currentTimeMillis();
        List<Municipio> municipioList = taskUtil.start();
        System.out.println(System.currentTimeMillis() - tempoInicial);
    }

    public void setup() throws IOException {
        loadFromUrl();
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
