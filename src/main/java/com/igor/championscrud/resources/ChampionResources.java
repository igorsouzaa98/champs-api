package com.igor.championscrud.resources;

import com.igor.championscrud.model.Champions;
import com.igor.championscrud.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
