package com.igor.championscrud.service;

import com.igor.championscrud.model.Champions;
import com.igor.championscrud.model.Role;
import com.igor.championscrud.repository.ChampionsRepository;
import com.igor.championscrud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ChampionsRepository championsRepository;

    public void instaciaBaseDeDados(){
        Role jungler = new Role(null, "Jungler");
        Role adc = new Role(null, "AD Carry");
        Role sup = new Role(null, "Suporte");
        Role mid = new Role (null, "Mid Laner");
        Role top = new Role(null, "Top Laner");

        Champions kindred = new Champions(null, "Kindred", "AD Damage", "S+", jungler);
        Champions cait = new Champions(null, "Caitlyn", "AD Damage", "S", adc);
        Champions lulu = new Champions(null,"Lulu", "AP Damage", "S+", sup);
        Champions ahri = new Champions(null, "Ahri", "AP Damage", "S", mid);
        Champions irelia = new Champions(null, "Irelia", "AD Damage", "S", top);

        jungler.getChampions().addAll(Arrays.asList(kindred));
        adc.getChampions().addAll(Arrays.asList(cait));
        sup.getChampions().addAll(Arrays.asList(lulu));
        mid.getChampions().addAll(Arrays.asList(ahri));
        top.getChampions().addAll(Arrays.asList(irelia));

        this.roleRepository.saveAll(List.of(jungler, adc, sup, mid, top));
        this.championsRepository.saveAll(List.of(kindred, cait, lulu, ahri, irelia));

    }
}
