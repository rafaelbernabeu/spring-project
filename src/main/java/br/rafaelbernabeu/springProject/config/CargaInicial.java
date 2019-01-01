package br.rafaelbernabeu.springProject.config;

import br.rafaelbernabeu.springProject.config.cargaInicial.AlunoCarga;
import br.rafaelbernabeu.springProject.config.cargaInicial.EstadosCarga;
import br.rafaelbernabeu.springProject.config.cargaInicial.UsuarioCarga;
import br.rafaelbernabeu.springProject.util.ThreadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioCarga usuarioCarga;

    @Autowired
    private AlunoCarga alunoCarga;

    @Autowired
    private EstadosCarga estadosCarga;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Collection<Callable<Boolean>> executaveis = new ArrayList<>();
        executaveis.add(usuarioCarga);
        executaveis.add(alunoCarga);
        executaveis.add(estadosCarga);

        try {
            executaAcoes(executaveis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private <T> void executaAcoes(Collection<Callable<T>> executaveis) throws InterruptedException {
        List<Future<T>> futures = ThreadUtil.getExecutorService().invokeAll(executaveis);
        futures.forEach(x -> {
            try {
                while (!x.isDone()) {
                    System.out.println("Esperando...");
                    Thread.sleep(1);
                }
                System.out.println("Acadou!!!");
                System.out.println(x.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
