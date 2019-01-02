package br.rafaelbernabeu.springProject.config;

import br.rafaelbernabeu.springProject.config.cargaInicial.AlunoCarga;
import br.rafaelbernabeu.springProject.config.cargaInicial.LocalidadesCarga;
import br.rafaelbernabeu.springProject.config.cargaInicial.UsuarioCarga;
import br.rafaelbernabeu.springProject.util.ThreadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioCarga usuarioCarga;

    @Autowired
    private AlunoCarga alunoCarga;

    @Autowired
    private LocalidadesCarga localidadesCarga;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            executaAcoes(Arrays.asList(
                    usuarioCarga,
                    localidadesCarga,
                    alunoCarga
            ));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private <T> void executaAcoes(Collection<Callable<T>> executaveis) throws InterruptedException {
        ExecutorService executorService = ThreadUtil.getExecutorService();
        executaveis.forEach(executorService::submit);
    }
}
