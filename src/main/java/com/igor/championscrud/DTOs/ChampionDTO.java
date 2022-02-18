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
    private String damage;
    private String tier;

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public ChampionDTO() {
        super();
    }

    public ChampionDTO(Champions obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.damage = obj.getDamage();
        this.tier = obj.getTier();
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
