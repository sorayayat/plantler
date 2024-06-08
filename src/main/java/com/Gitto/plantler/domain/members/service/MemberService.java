package com.Gitto.plantler.domain.members.service;

import com.Gitto.plantler.domain.members.Memberdto.Memberdto;

public interface MemberService {

    void saveMember(Memberdto memberdto);
    void deleteMember(Long memberId);
    // 중복 회원 확인 메소드
    boolean isUsernameAvailable(String username);

    Memberdto Login(Memberdto memberdto);

}
