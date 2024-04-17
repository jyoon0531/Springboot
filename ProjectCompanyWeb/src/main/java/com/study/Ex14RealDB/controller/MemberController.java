package com.study.Ex14RealDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "/member/join2";
    }

    @PostMapping("/joinAction")
    public String joinAction() {
        return "";
    }

    @GetMapping("/idFind")
    public String idFind() {

        return "member/idFind";
    }
}
