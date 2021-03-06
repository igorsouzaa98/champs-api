package com.igor.championscrud.service;


import com.igor.championscrud.model.Champions;
import com.igor.championscrud.model.Role;
import com.igor.championscrud.repository.ChampionsRepository;
import com.igor.championscrud.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ChampionsService {

    @Autowired
    private ChampionsRepository repository;

    @Autowired
    private RoleService roleService;

    public Champions findById(Long id){
        Optional<Champions>obj = repository.findById(id);
        return  obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: " + Champions.class.getName()));
    }

    public List<Champions> findAll(Long id_rol) {
        roleService.findById(id_rol);
        return repository.findAllByRole(id_rol);
    }

    public Champions update(Long id, Champions obj) {
        Champions newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Champions newObj, Champions obj) {
        newObj.setNome(obj.getNome());
        newObj.setDamage(obj.getDamage());
        newObj.setRole(obj.getRole());
        newObj.setTier(obj.getTier());
    }

    public Champions create(Long id_rol, Champions obj) {
        obj.setId(null);
        Role rol = roleService.findById(id_rol);
        obj.setRole(rol);
        return repository.save(obj);
    }


    public void delete(Long id) {
        Champions obj = findById(id);
        repository.delete(obj);

    }
}
