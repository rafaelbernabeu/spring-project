package br.rafaelbernabeu.rafaelbernabeu.repository;

import br.rafaelbernabeu.rafaelbernabeu.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {

}