package com.igor.championscrud.DTOs;

import com.igor.championscrud.model.Champions;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ChampionDTO implements Serializable {
    private Long id;

    @NotEmpty(message = "Campo 'nome' é requerido")
    @Length(min = 3, max = 30, message = "O Campo 'nome' deve ter entre 3 e 30 caracteres")
    private String nome;

    public ChampionDTO() {
        super();
    }

    public ChampionDTO(Champions obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
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
}
