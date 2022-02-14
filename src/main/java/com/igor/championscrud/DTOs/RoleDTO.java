package com.igor.championscrud.DTOs;

import com.igor.championscrud.model.Role;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class RoleDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "Campo 'nome' é requerido")
    @Length(min = 3, max = 16, message = "O Campo 'nome' deve ter entre 3 e 16 caracteres")
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
