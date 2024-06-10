package com.Gitto.plantler.domain.plants.entity;

import com.Gitto.plantler.domain.members.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Plants")
public class Plants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long plantId;

    // 사용자가 저장할 이름
    @Column(nullable = false, unique = true)
    private String nickname;

    // 식물 이름 (종류)
    @Column()
    private String plantName;

    // 날짜 (파종일)
    @Column(nullable = false)
    private LocalDate sowingDate;

    // 물주기
    private LocalDate watering;

    // 환기
    private LocalDate ventilation;

    // 영양제
    private LocalDate nutrition;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
