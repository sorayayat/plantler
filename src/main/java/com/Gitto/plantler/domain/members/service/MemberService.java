package com.Gitto.plantler.domain.members.service;

import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.entity.Member;

public interface MemberService {

    public abstract Long saveMember(Member member);
    void deleteMember(String username);
    // 중복 회원 확인 메소드
    boolean isUsernameAvailable(String username);

    String Login(Memberdto memberdto);

}
