package com.igor.championscrud.DTOs;

import com.igor.championscrud.model.Champions;

import java.io.Serializable;

public class ChampionDTO implements Serializable {
    private Long id;
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
