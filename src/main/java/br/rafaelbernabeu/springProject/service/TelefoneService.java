package br.rafaelbernabeu.springProject.service;

import br.rafaelbernabeu.springProject.entity.Telefone;
import br.rafaelbernabeu.springProject.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    public Telefone salvar(Telefone telefone) {
        return repository.save(telefone);
    }
}