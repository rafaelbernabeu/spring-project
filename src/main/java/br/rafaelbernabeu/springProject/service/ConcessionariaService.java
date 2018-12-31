package br.rafaelbernabeu.springProject.service;

import br.rafaelbernabeu.springProject.entity.Concessionaria;
import br.rafaelbernabeu.springProject.repository.ConcessionariaRepository;
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