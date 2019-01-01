package br.rafaelbernabeu.springProject.entity.localidades;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Microrregiao {

    @Id
    private Long id;
    private String nome;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private Mesorregiao mesorregiao;


}
