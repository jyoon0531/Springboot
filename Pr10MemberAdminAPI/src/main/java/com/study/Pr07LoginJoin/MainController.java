package com.study.Pr07LoginJoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequiredArgsConstructor
public class MainController {

    final MemberRepository memberRepository;

    public MainController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        Member m1 = Member.builder()
                .username("admin").password("1111").email("abc@test.com").joindate(LocalDate.parse("2024-04-05"))
                .build();
        MemberRepository.memberList.add(m1);
        Member m2 = Member.builder()
                .username("tom").password("2222").email("tom@test.com").joindate(LocalDate.parse("2024-04-05"))
                .build();
        MemberRepository.memberList.add(m2);
        Member m3 = Member.builder()
                .username("hana").password("3333").email("hana@test.com").joindate(LocalDate.parse("2024-04-05"))
                .build();
        MemberRepository.memberList.add(m3);

    }

    @GetMapping("/")
    public String main() {
        return "login";
    }


    @GetMapping("/join-form")
    public String joinForm() {
        return "join";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/update-form")
    public String updateForm(@RequestParam int index, Model model) {
        model.addAttribute("member", MemberRepository.memberList.get(index));
        model.addAttribute("index", index);
        return "modify";
    }
}
