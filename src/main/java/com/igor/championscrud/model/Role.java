package com.igor.championscrud.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo 'nome' é requerido")
    @Length(min = 3, max = 16, message = "O Campo 'nome' deve ter entre 3 e 16 caracteres")
    private String nome;

    @OneToMany(mappedBy = "role") // Linkando essa categoria a outra "Uma para muitas"
    private final List<Champions> champions = new ArrayList<>();


    public Role() {
        super();
    }

    public Role(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public List<Champions> getChampions() {
        return champions;
    }
}


