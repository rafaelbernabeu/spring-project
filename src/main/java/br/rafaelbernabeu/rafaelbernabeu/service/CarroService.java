package br.rafaelbernabeu.rafaelbernabeu.service;

import br.rafaelbernabeu.rafaelbernabeu.entity.Carro;
import br.rafaelbernabeu.rafaelbernabeu.repository.CarroRepository;
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