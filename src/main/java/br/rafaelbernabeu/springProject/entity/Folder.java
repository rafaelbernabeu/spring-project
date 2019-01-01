package br.rafaelbernabeu.springProject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FOLDER_SONG")
    private List<Song> songs;


}