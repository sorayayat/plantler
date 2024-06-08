package com.Gitto.plantler.domain.members.entity;

import com.Gitto.plantler.domain.plants.entity.Plants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userid;

    private String password;

    private String role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Plants> plants;
}
