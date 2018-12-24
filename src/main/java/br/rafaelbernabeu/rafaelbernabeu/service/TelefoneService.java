package br.rafaelbernabeu.rafaelbernabeu.service;

import br.rafaelbernabeu.rafaelbernabeu.entity.Telefone;
import br.rafaelbernabeu.rafaelbernabeu.repository.TelefoneRepository;
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