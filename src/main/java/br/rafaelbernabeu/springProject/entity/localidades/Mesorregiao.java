package br.rafaelbernabeu.springProject.entity.localidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Mesorregiao {

    @Id
    private Long id;
    private String nome;

    @JsonProperty(value = "UF")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private Estado uf;


}
