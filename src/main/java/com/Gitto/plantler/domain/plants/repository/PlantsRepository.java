package com.Gitto.plantler.domain.plants.repository;

import com.Gitto.plantler.domain.plants.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantsRepository extends JpaRepository<Plants, Long> {

    Optional<Plants> findPlantsByNickname(String nickName);
}