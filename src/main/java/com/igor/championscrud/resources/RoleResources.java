package com.igor.championscrud.resources;

import com.igor.championscrud.model.Role;
import com.igor.championscrud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles")
public class RoleResources {

    @Autowired
    private RoleService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id){
        Role obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
