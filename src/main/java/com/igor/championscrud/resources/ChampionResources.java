package com.igor.championscrud.resources;

import com.igor.championscrud.DTOs.ChampionDTO;
import com.igor.championscrud.model.Champions;
import com.igor.championscrud.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/champions")
public class ChampionResources {

    @Autowired
    private ChampionsService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Champions>findById(@PathVariable Long id){
    Champions obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ChampionDTO>> findAll(@RequestParam(value="role", defaultValue = "0")Long id_rol){
        List<Champions> list = service.findAll(id_rol);
        List<ChampionDTO> listDTO = list.stream().map(ChampionDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Champions>update(@PathVariable Long id, @RequestBody Champions obj){
        Champions newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Champions>updatePatch(@PathVariable Long id, @RequestBody Champions obj){
        Champions newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Champions> create(@RequestParam(value = "role", defaultValue = "0") Long id_rol, @RequestBody Champions obj){

        Champions newObj = service.create(id_rol, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/champions/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
