package com.igor.championscrud.resources;

import com.igor.championscrud.DTOs.RoleDTO;
import com.igor.championscrud.model.Role;
import com.igor.championscrud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<List<RoleDTO>>findAll(){
        List<Role> list = service.findAll();
        List<RoleDTO> listDTO = list.stream().map(obj -> new RoleDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable Long id, @RequestBody RoleDTO objDTO){
        Role newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new RoleDTO(newObj));

    }
}
