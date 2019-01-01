package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.localidades.Estado;
import br.rafaelbernabeu.springProject.service.localidades.EstadoService;
import br.rafaelbernabeu.springProject.util.IBGEServiceUtil;
import br.rafaelbernabeu.springProject.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@Service
public class EstadosCarga implements Callable<Boolean> {

    @Autowired
    EstadoService estadoService;

    private void loadFromUrl() throws IOException {
        List<Estado> estados = URLUtil.fetchAndParseList(IBGEServiceUtil.URL_SERVICE_ESTADOS, Estado.class);
        estadoService.salvar(estados);
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
