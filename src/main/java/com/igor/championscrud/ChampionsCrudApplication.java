package com.igor.championscrud;

import com.igor.championscrud.model.Champions;
import com.igor.championscrud.model.Role;
import com.igor.championscrud.repository.ChampionsRepository;
import com.igor.championscrud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ChampionsCrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChampionsCrudApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ChampionsRepository championsRepository;

    @Override
    public void run(String... args) throws Exception {
        Role jungler = new Role(null, "Jungler");
        Champions kindred = new Champions(null, "Kindred", "AD Damage", "S+", jungler);

        jungler.getChampions().addAll(List.of(kindred));

        this.roleRepository.saveAll(List.of(jungler));
        this.championsRepository.saveAll(List.of(kindred));

    }
}
