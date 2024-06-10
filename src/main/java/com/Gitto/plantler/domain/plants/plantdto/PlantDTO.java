package com.Gitto.plantler.domain.plants.plantdto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PlantDTO {

    private Long id;
    private String nickname;
    private String plantName;
    private LocalDate sowingDate;
    // 물주기
    private LocalDate watering;
    // 환기
    private LocalDate ventilation;
    // 영양제
    private LocalDate nutrition;

    public PlantDTO(Long id, String nickname, String plantName, LocalDate sowingDate, LocalDate watering, LocalDate ventilation, LocalDate nutrition) {
        this.id = id;
        this.nickname = nickname;
        this.plantName = plantName;
        this.sowingDate = sowingDate;
        this.watering = watering;
        this.ventilation = ventilation;
        this.nutrition = nutrition;
    }

}
