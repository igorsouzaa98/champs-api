package com.igor.championscrud.service;

import com.igor.championscrud.DTOs.RoleDTO;
import com.igor.championscrud.model.Role;
import com.igor.championscrud.repository.RoleRepository;
import com.igor.championscrud.service.exceptions.DataIntegrityViolationException;
import com.igor.championscrud.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


    @Autowired
    private RoleRepository repository;
    public Role findById(Long id){
        Optional<Role> obj = repository.findById(id);
        return  obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrato! ID: " + id + ", Tipo: " + Role.class.getName()));
    }//metodo que vai procurar a role por id, caso n encontre vai retornar uma msg de erro

    public List<Role>findAll(){
        return repository.findAll();
    }

    public Role create(Role obj){
        obj.setId(null);
        return repository.save(obj);
    }
    public Role update(Long id, RoleDTO objDTO){
        Role obj = findById(id);
        obj.setNome(objDTO.getNome());
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Role não pode ser deletada! Possui livros associados");
        }
    }
}
