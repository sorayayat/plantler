package com.Gitto.plantler.domain.members.Memberdto;

import lombok.*;


/* 로직 내부에서 인증 유저의 정보를 저장해 둘 곳 */
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserInfoDto extends Memberdto{

    private Long id;
    private String memberId;
    private String password;
    private String role;


}
