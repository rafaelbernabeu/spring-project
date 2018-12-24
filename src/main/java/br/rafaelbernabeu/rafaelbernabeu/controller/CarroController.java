package br.rafaelbernabeu.rafaelbernabeu.controller;

import br.rafaelbernabeu.rafaelbernabeu.entity.Carro;
import br.rafaelbernabeu.rafaelbernabeu.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Carro> getCarro(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Carro setCarro(@RequestBody Carro carro){
        return repository.save(carro);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Carro updateCarro(@RequestBody Carro carro){
        return repository.save(carro);
    }


    @RequestMapping(value = "/{carroId}", method = RequestMethod.DELETE)
    public void deleteCarro(@PathVariable Long carroId){
        repository.deleteById(carroId);
    }

}