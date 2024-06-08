package com.Gitto.plantler.domain.plants.service;

import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PlantsService {

    List<Plants> plantList(Long Id);

    void savePlant(PlantDTO plantDTO);
}
