package com.Gitto.plantler.domain.plants.controller;

import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import com.Gitto.plantler.domain.plants.repository.PlantsRepository;
import com.Gitto.plantler.domain.plants.service.PlantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class plantController {

    @Autowired
    private final PlantsRepository plantsRepository;
    private final PlantsService plantsService;

    public plantController(PlantsRepository plantsRepository, PlantsService plantsService) {
        this.plantsRepository = plantsRepository;
        this.plantsService = plantsService;
    }

    @PostMapping("/save-plant")
    public String savePlant(PlantDTO plantDTO){
        try {
            Plants plants = new Plants();
            plants.setPlantName(plantDTO.getPlantName());
            plants.setNickname(plantDTO.getNickname());
            plants.setSowingDate(plantDTO.getSowingDate());
            plantsRepository.save(plants);

        } catch (Exception e) {
            throw new IllegalArgumentException("error:", e);
        }

        return "main";
    }
}
