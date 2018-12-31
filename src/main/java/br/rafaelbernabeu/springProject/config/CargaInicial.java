package br.rafaelbernabeu.springProject.config;

import br.rafaelbernabeu.springProject.entity.Aluno;
import br.rafaelbernabeu.springProject.entity.Role;
import br.rafaelbernabeu.springProject.entity.User;
import br.rafaelbernabeu.springProject.service.AlunoService;
import br.rafaelbernabeu.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        salvarAluno();
        salvarAdmin();
        salvarUser();
    }

    private void salvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setName("Rafael");
        aluno.setOld(27);

        alunoService.salvar(aluno);
    }

    private void salvarUser() {
        User user = new User();
        user.setNome("User");
        user.setEmail("rafael@rafaelbernabeu.net");
        user.setPassword("{noop}123abc");
        user.setRoles(Collections.singletonList(new Role("ROLE_USER")));

        userService.salvar(user);
    }

    private void salvarAdmin() {
        User user = new User();
        user.setNome("Admin");
        user.setEmail("admin@rafaelbernabeu.net");
        user.setPassword("{noop}123abc");
        user.setRoles(Collections.singletonList(new Role("ROLE_ADMIN")));

        userService.salvar(user);
    }
}
