package br.rafaelbernabeu.rafaelbernabeu.service;

import br.rafaelbernabeu.rafaelbernabeu.entity.Concessionaria;
import br.rafaelbernabeu.rafaelbernabeu.repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcessionariaService {

    @Autowired
    private ConcessionariaRepository repository;

    public Concessionaria salvar(Concessionaria concessionaria) {
        return repository.save(concessionaria);
    }

}