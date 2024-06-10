package com.Gitto.plantler.domain.plants.controller;

import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import com.Gitto.plantler.domain.plants.service.PlantsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plants")
public class plantController {

    private final PlantsService plantsService;
    public plantController(PlantsService plantsService) {
        this.plantsService = plantsService;
    }


    @GetMapping("/new")
    public String showForm(){
        return "addPlants";
    }

    @PostMapping("/save-plant")
    public String savePlant(PlantDTO plantDTO, Model model) {
        try {
            plantsService.savePlant(plantDTO);
            return "redirect:/Home";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
