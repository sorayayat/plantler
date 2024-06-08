package com.Gitto.plantler.domain.members.controller;

import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @PostMapping("/login/login-proc")
    public String login_proc(Memberdto memberdto){
        System.out.println("successes");
        return "/Home";
    }
}
