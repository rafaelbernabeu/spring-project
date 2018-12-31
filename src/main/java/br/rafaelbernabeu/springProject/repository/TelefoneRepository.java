package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {


}
