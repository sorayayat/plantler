package com.Gitto.plantler.domain.plants.service;

import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;

import java.util.List;

public interface PlantsService {

   List<Plants> plantList(Long Id);

    void savePlant(PlantDTO plantDTO);

    void deletePlant(PlantDTO plantDTO);
}
