package com.Gitto.plantler.domain.members.service;

import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MemberServiceimpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberServiceimpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원 가입
    @Override
    public void saveMember(Memberdto memberdto) {
        try {
            if (isUsernameAvailable(memberdto.getMemberId())) {
                throw new IllegalStateException("이미 가입된 아이디");
            } else {
                Member member = new Member();
                member.setUserid(memberdto.getMemberId());
                member.setPassword(passwordEncoder.encode(member.getPassword()));
                member.setRole("user");
                memberRepository.save(member);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("가입 중 발생 했습니다.");
        }

    }
    // 중복 회원 확인 메소드
    @Override
    public boolean isUsernameAvailable(String username) {
        Optional<Member> existingMember = memberRepository.findByUserid(username);
        return existingMember.isPresent();
    }


    @Override
    public void deleteMember(Long memberId) {

    }


    @Override
    public Memberdto Login(Memberdto memberdto) {
        return null;
    }

}
