package br.rafaelbernabeu.springProject.config;

import br.rafaelbernabeu.springProject.config.cargaInicial.AlunoCarga;
import br.rafaelbernabeu.springProject.config.cargaInicial.UsuarioCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioCarga usuarioCarga;

    @Autowired
    private AlunoCarga alunoCarga;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        usuarioCarga.setup();
        alunoCarga.setup();
    }
}
