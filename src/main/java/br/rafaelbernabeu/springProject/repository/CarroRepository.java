package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {


}
