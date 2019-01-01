package br.rafaelbernabeu.springProject.controller;

import br.rafaelbernabeu.springProject.entity.Aluno;
import br.rafaelbernabeu.springProject.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Aluno> getAluno(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Aluno setAluno(@RequestBody Aluno aluno){
        return repository.save(aluno);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Aluno updateAluno(@RequestBody Aluno aluno){
        return repository.save(aluno);
    }

    @RequestMapping(value = "/{alunoId}", method = RequestMethod.DELETE)
    public void deleteAluno(@PathVariable Long alunoId){
        repository.deleteById(alunoId);
    }

}