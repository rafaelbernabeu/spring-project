package br.rafaelbernabeu.rafaelbernabeu.service;

import br.rafaelbernabeu.rafaelbernabeu.entity.Aluno;
import br.rafaelbernabeu.rafaelbernabeu.repository.AlunoRepository;
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