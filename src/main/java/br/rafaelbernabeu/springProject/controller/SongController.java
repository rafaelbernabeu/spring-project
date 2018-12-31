package br.rafaelbernabeu.springProject.controller;

import br.rafaelbernabeu.springProject.entity.Song;
import br.rafaelbernabeu.springProject.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("song")
public class SongController {

    @Autowired
    private SongRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Song> getSong(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Song setSong(@RequestBody Song song){
        return repository.save(song);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Song updateSong(@RequestBody Song song){
        return repository.save(song);
    }


    @RequestMapping(value = "/{songId}", method = RequestMethod.DELETE)
    public void deleteSong(@PathVariable Long songId){
        repository.deleteById(songId);
    }

}