package com.Gitto.plantler.domain.plants.repository;

import com.Gitto.plantler.domain.plants.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantsRepository extends JpaRepository<Plants, Long> {

    // 회원이 가지고 있는 식물 확인
    List<Plants> findPlantsByPlantId(Long  plantId);
}