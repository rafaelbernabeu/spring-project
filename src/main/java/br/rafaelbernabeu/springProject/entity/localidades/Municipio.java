package br.rafaelbernabeu.springProject.entity.localidades;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Municipio {

    @Id
    private Long id;
    private String nome;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Microrregiao microrregiao;

}
