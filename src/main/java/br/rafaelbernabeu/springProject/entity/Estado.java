package br.rafaelbernabeu.springProject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sigla;
    private String nome;

    @OneToOne
    private Regiao regiao;
}
