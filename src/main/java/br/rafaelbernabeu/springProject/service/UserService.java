package br.rafaelbernabeu.springProject.service;

import br.rafaelbernabeu.springProject.entity.User;
import br.rafaelbernabeu.springProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User salvar(User user) {
        return repository.save(user);
    }
}