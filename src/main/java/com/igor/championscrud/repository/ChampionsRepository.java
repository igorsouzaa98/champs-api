package com.igor.championscrud.repository;

import com.igor.championscrud.model.Champions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepository extends JpaRepository<Champions, Long> {
}
