package com.Gitto.plantler.domain.plants.plantdto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PlantDTO {
    private String nickname;

    private String plantName;

    private LocalDate sowingDate;
}
