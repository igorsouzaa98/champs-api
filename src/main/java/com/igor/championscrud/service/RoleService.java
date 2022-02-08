package com.igor.championscrud.service;

import com.igor.championscrud.model.Role;
import com.igor.championscrud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;
    public Role findById(Long id){
        Optional<Role> obj = repository.findById(id);
        return  obj.orElse(null);
    }//metodo que vai procurar a role por id, caso n encontre vai retornar o valor nulo
}
