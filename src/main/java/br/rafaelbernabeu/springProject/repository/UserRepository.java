package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}