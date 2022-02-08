package com.igor.championscrud.DTOs;

import com.igor.championscrud.model.Role;

import java.io.Serial;
import java.io.Serializable;

public class RoleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public RoleDTO(){
        super();
    }

    public RoleDTO(Role obj) {
        this.id = obj.getId();
        this.nome =obj.getNome();
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
