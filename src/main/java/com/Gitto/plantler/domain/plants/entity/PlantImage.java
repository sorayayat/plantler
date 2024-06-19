package com.Gitto.plantler.domain.plants.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PlantImage {

    @Id
    private Long id;

    private String filePath;

    private String fileName;

    private int fileSize;


}
