package com.igor.championscrud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Role {
    private Long id;
    private String nome;


    private  List<Champions> champions = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


