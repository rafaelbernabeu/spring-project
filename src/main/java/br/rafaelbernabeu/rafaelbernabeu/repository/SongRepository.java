package br.rafaelbernabeu.rafaelbernabeu.repository;

import br.rafaelbernabeu.rafaelbernabeu.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}