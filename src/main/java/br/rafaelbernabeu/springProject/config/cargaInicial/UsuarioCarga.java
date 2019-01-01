package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.Role;
import br.rafaelbernabeu.springProject.entity.User;
import br.rafaelbernabeu.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioCarga {

    @Autowired
    private UserService userService;

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

    public void setup() {
        salvarAdmin();
        salvarUser();
    }
}
