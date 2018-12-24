package br.rafaelbernabeu.rafaelbernabeu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelo;
    private String marca;
    private String operadora;
    private String numero;

}