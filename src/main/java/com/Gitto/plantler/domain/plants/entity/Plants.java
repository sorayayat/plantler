package com.Gitto.plantler.domain.plants.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Plants {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자가 저장할 이름
    private String nickname;

    // 식물 이름 (종류)
    private String plantName;

    // 물주기
    // 환기
    // 영양제
}
