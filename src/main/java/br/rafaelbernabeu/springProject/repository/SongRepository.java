package br.rafaelbernabeu.springProject.repository;

import br.rafaelbernabeu.springProject.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}