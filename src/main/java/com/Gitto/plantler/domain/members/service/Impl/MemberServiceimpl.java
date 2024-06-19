package com.Gitto.plantler.domain.members.service.Impl;

import com.Gitto.plantler.domain.common.Jwtutil;
import com.Gitto.plantler.domain.members.Memberdto.CustomUserInfoDto;
import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.entity.CustomUserDetails;
import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import com.Gitto.plantler.domain.members.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MemberServiceimpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final Jwtutil jwtutil;
    private final ModelMapper modelMapper;

    public MemberServiceimpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder, Jwtutil jwtutil, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtutil = jwtutil;
        this.modelMapper = modelMapper;
    }

    // 회원 가입
    @Override
    public Long saveMember(Member member) {
        try {
            if (isUsernameAvailable(member.getUserid())) {
                throw new IllegalStateException("이미 가입된 아이디");
            } else {
                Member joinMember = new Member();
                member.setUserid(joinMember.getUserid());
                member.setPassword(passwordEncoder.encode(member.getPassword()));
                member.setRole("user");
                memberRepository.save(member);
                return member.getId();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("가입 중 발생 했습니다.");
        }
    }

    @Override
    public void deleteMember(String username) {

    }

    // 중복 회원 확인 메소드
    @Override
    public boolean isUsernameAvailable(String username) {
        Optional<Member> existingMember = memberRepository.findByUserid(username);
        return existingMember.isPresent();
    }

    @Override
    @Transactional
    public String Login(Memberdto memberdto) {
        String login = memberdto.getMemberId();
        String pw = memberdto.getPassword();

        if (login == null) {
            throw new UsernameNotFoundException("id가 없습니다.");
        }
        if (!passwordEncoder.matches(pw, memberdto.getPassword())) {
            throw new BadCredentialsException("비밀번호를 확인해주세요");
        }

        CustomUserInfoDto info = modelMapper.map(memberdto, CustomUserInfoDto.class);

        String accessToken = jwtutil.createAccessToken(info);

        return accessToken;
    }

}
