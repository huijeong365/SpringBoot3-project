package com.example.SpringBoot3.controller;

import com.example.SpringBoot3.dto.MemberFormDto;
import com.example.SpringBoot3.entity.Member;
import com.example.SpringBoot3.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/join")
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "join";
    }

    @PostMapping(value = "/join")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "join";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "join";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "/login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/login";
    }

}