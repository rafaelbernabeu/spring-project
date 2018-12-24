package br.rafaelbernabeu.rafaelbernabeu.controller;

import br.rafaelbernabeu.rafaelbernabeu.entity.Concessionaria;
import br.rafaelbernabeu.rafaelbernabeu.repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("concessionaria")
public class ConcessionariaController {

    @Autowired
    private ConcessionariaRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Concessionaria> getConcessionaria(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Concessionaria setConcessionaria(@RequestBody Concessionaria user){
        return repository.save(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Concessionaria updateConcessionaria(@RequestBody Concessionaria user){
        return repository.save(user);
    }

    @RequestMapping(value = "/{concessionariaId}", method = RequestMethod.DELETE)
    public void deleteConcessionaria(@PathVariable Long concessionariaId){
        repository.deleteById(concessionariaId);
    }

}