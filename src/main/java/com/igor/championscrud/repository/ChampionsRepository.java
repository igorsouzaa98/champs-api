package com.igor.championscrud.repository;

import com.igor.championscrud.model.Champions;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChampionsRepository extends JpaRepository<Champions, Long> {

    @Query("SELECT obj FROM Champions obj WHERE obj.role.id = :id_rol order by 'nome' ")
    List<Champions> findAllByRole(@Param(value = "id_rol") Long id_rol);
}
