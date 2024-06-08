package com.Gitto.plantler.domain.members.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userid;

    private String password;

    private String role;

}
