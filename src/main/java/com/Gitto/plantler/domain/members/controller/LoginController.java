package com.Gitto.plantler.domain.members.controller;

import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {
    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @PostMapping("login")
    public ResponseEntity<String> getMemberProfile(@Valid @RequestBody Memberdto dto) {
        String token = memberService.Login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
