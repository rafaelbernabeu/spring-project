package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {

}