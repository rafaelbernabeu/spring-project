package br.rafaelbernabeu.rafaelbernabeu.repository;

import br.rafaelbernabeu.rafaelbernabeu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}