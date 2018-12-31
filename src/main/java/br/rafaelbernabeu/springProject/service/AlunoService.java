package br.rafaelbernabeu.springProject.service;

import br.rafaelbernabeu.springProject.entity.Aluno;
import br.rafaelbernabeu.springProject.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }
}