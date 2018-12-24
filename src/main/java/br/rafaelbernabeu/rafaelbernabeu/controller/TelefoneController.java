package br.rafaelbernabeu.rafaelbernabeu.controller;

import br.rafaelbernabeu.rafaelbernabeu.entity.Telefone;
import br.rafaelbernabeu.rafaelbernabeu.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Telefone> getTelefone(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Telefone setTelefone(@RequestBody Telefone telefone){
        return repository.save(telefone);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Telefone updateTelefone(@RequestBody Telefone telefone){
        return repository.save(telefone);
    }

    @RequestMapping(value = "/{telefoneId}", method = RequestMethod.DELETE)
    public void deleteTelefone(@PathVariable Long telefoneId){
        repository.deleteById(telefoneId);
    }

}