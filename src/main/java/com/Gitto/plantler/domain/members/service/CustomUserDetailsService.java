package com.Gitto.plantler.domain.members.service;

import com.Gitto.plantler.domain.common.CustomUserDetail;
import com.Gitto.plantler.domain.members.Memberdto.CustomUserInfoDto;
import com.Gitto.plantler.domain.members.entity.CustomUserDetails;
import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

   private final MemberRepository memberRepository;
   private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(Long.parseLong(username))
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저 없음"));

        CustomUserInfoDto dto = modelMapper.map(member, CustomUserInfoDto.class);
        return new CustomUserDetails(dto);
    }
}
