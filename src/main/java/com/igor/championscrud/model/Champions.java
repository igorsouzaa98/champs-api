package com.igor.championscrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Champions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo 'nome' é requerido")
    @Length(min = 3, max = 30, message = "O Campo 'nome' deve ter entre 3 e 30 caracteres")
    private String nome;
    @NotEmpty(message = "Campo 'Damage' é requerido")
    @Length(min = 3, max = 30, message = "O Campo 'damage' deve ter entre 3 e 30 caracteres")
    private String damage;
    @NotEmpty(message = "Campo 'tier' é requerido")
    @Length(min = 1, max = 16, message = "O Campo 'tier' deve ter entre 1 e 16 caracteres")
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
