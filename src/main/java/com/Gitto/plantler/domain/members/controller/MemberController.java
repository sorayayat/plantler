package com.Gitto.plantler.domain.members.controller;

import ch.qos.logback.core.model.Model;
import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import com.Gitto.plantler.domain.members.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    /* 회원 가입 */
    @PostMapping("/api/v1/member")
    public ResponseEntity<Long> addMember(@Valid @RequestBody Memberdto memberdto) {
        Member etitiy = modelMapper.map(memberdto, Member.class);
        Long id = memberService.saveMember(etitiy);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
