package com.Gitto.plantler.domain.plants.service;

import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import com.Gitto.plantler.domain.plants.repository.PlantsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PlantsServiceImpl implements PlantsService {

    private final PlantsRepository plantsRepository;

    public PlantsServiceImpl(PlantsRepository plantsRepository) {
        this.plantsRepository = plantsRepository;
    }

    @Override
    public List<Plants> plantList(Long Id) {
        return null;
    }

    @Override
    @Transactional
    public void savePlant(PlantDTO plantDTO) {
        try {
                Plants plants = new Plants();
            if (plantsRepository.findPlantsByNickname(plantDTO.getNickname()).isPresent()) {
                throw new IllegalArgumentException("중복된 닉네임 입니다.");
            }
                plants.setNickname(plantDTO.getNickname());
                plants.setPlantName(plantDTO.getPlantName());
                plants.setSowingDate(plantDTO.getSowingDate());
                plantsRepository.save(plants);

        } catch (Exception e) {
            throw new IllegalArgumentException("등록 실패");
        }
    }

    @Override
    public void deletePlant(PlantDTO plantDTO) {
        try {
            Plants plants = new Plants();
            if (plantsRepository.findPlantsByNickname(plantDTO.getNickname()).isPresent()) {
                plants.setNickname(plantDTO.getNickname());
                plants.setPlantName(plantDTO.getPlantName());
                plants.setSowingDate(plantDTO.getSowingDate());
                plantsRepository.delete(plants);
            } else {
                throw new IllegalArgumentException("찾을 수 없습니다. 한번 더 확인해 주세요");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("등록 실패");
        }
    }

}
