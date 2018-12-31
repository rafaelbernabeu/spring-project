package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
