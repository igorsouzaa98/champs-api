package com.igor.championscrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Champions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String damage;
    private String tier;

    @JsonIgnore
    @ManyToOne //linkando uma classe na outra "Muitos para um"
    @JoinColumn(name = "role_id")
    private Role role;

    public Champions(){
        super();
    }
    public Champions(Long id, String nome, String damage, String tier, Role role) {
        this.id = id;
        this.nome = nome;
        this.damage = damage;
        this.tier = tier;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
