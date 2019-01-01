package br.rafaelbernabeu.springProject.entity.localidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Regiao {

    @Id
    private Long id;
    private String sigla;
    private String nome;

}
