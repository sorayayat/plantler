package com.Gitto.plantler.domain.plants.service;

import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.plantdto.PlantDTO;
import com.Gitto.plantler.domain.plants.repository.PlantsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class PlantsServiceImpl implements PlantsService {
    private final PlantsRepository plantsRepository;
    public PlantsServiceImpl(PlantsRepository plantsRepository) {
        this.plantsRepository = plantsRepository;
    }

    @Override
    public List<Plants> plantList(Long Id) {
        return plantsRepository.findAll();
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

    // 물주기
    @Override
    public LocalDate watering(PlantDTO plantDTO) {
        Optional<Plants> updatePlant = plantsRepository.findPlantsByNickname(plantDTO.getNickname());
        if (updatePlant.isPresent()) {
            Plants p = updatePlant.get();
            p.setWatering(LocalDate.now());
            plantsRepository.save(p);
            return p.getWatering();
        } else {
            throw new IllegalArgumentException("존재하지 않는 식물입니다.");
        }
    }

    // 환기
    @Override
    public LocalDate ventilation(PlantDTO plantDTO) {
        Optional<Plants> updatePlant = plantsRepository.findPlantsByNickname(plantDTO.getNickname());
        if (updatePlant.isPresent()) {
            Plants p = updatePlant.get();
            p.setVentilation(LocalDate.now());
            plantsRepository.save(p);
            return p.getWatering();
        } else {
            throw new IllegalArgumentException("존재하지 않는 식물입니다.");
        }
    }

    // 영양제
    @Override
    public LocalDate nutrition(PlantDTO plantDTO) {
        Optional<Plants> updatePlant = plantsRepository.findPlantsByNickname(plantDTO.getNickname());
        if (updatePlant.isPresent()) {
            Plants p = updatePlant.get();
            p.setNutrition(LocalDate.now());
            plantsRepository.save(p);
            return p.getWatering();
        } else {
            throw new IllegalArgumentException("존재하지 않는 식물입니다.");
        }
    }


}
