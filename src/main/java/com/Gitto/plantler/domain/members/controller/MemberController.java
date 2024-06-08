package com.Gitto.plantler.domain.members.controller;

import ch.qos.logback.core.model.Model;
import com.Gitto.plantler.domain.members.Memberdto.Memberdto;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import com.Gitto.plantler.domain.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입 화면 보여줌
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        return "/signup";
    }

    // 회원 가입을 받을 페이지 성공하면 로그인 화면으로 이동
    @PostMapping("/signup")
    public String signup(Memberdto memberdto) {
        memberService.saveMember(memberdto);
        return "redirect:/login";
    }

    @GetMapping("/signup/checkUsername/{username}")
    public ResponseEntity<String> checkUsernameExists(@PathVariable String username) {
        boolean isAvailable = memberService.isUsernameAvailable(username);
        if(!isAvailable) {
            return ResponseEntity.ok("사용 가능한 사용자명입니다.");
        } else {
            return ResponseEntity.ok("이미 사용 중인 사용자명입니다. 다른 이름을 시도해주세요.");
        }
    }
}
