package com.Gitto.plantler.domain.plants.service;

import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import com.Gitto.plantler.domain.plants.repository.PlantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantsServiceImpl implements PlantsService{

    private final PlantsRepository plantsRepository;

    public PlantsServiceImpl(PlantsRepository plantsRepository) {
        this.plantsRepository = plantsRepository;
    }

    @Override
    public List<Plants> plantList(Long Id) {
        return null;
    }

    @Override
    public void savePlant(PlantDTO plantDTO) {
        Plants plant = new Plants();

        plant.setNickname(plant.getNickname());
        plant.setPlantName(plant.getPlantName());

        plantsRepository.save(plant);
    }
}
