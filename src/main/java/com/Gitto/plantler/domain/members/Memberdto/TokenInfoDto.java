package com.Gitto.plantler.domain.members.Memberdto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TokenInfoDto {

    private String grantType;

    private String accessToken;

}