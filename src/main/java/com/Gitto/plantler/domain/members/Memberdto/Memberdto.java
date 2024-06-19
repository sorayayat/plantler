package com.Gitto.plantler.domain.members.Memberdto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Memberdto {

    private Long id;

    @NotBlank(message = "ID를 입력해주세요")
    private String memberId;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    private String role;


}
