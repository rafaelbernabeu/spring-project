package br.rafaelbernabeu.springProject.controller;

import br.rafaelbernabeu.springProject.entity.Concessionaria;
import br.rafaelbernabeu.springProject.repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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