package com.igor.championscrud.service;


import com.igor.championscrud.model.Champions;
import com.igor.championscrud.repository.ChampionsRepository;
import com.igor.championscrud.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionsService {

    @Autowired
    private ChampionsRepository repository;

    public Champions findById(Long id){
        Optional<Champions>obj = repository.findById(id);
        return  obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: " + Champions.class.getName()));
    }

}
