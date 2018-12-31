package br.rafaelbernabeu.springProject.service;

import br.rafaelbernabeu.springProject.entity.Carro;
import br.rafaelbernabeu.springProject.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

}