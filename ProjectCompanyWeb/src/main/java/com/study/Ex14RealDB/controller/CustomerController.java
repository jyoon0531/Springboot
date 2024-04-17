package com.study.Ex14RealDB.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @GetMapping("/customer01")
    @ResponseBody
    public String customer01(HttpSession session) {
        if (session.getAttribute("loginId") == null) {
            return "<script>alert('로그인을 해주세요'); location.href='/member/login';</script>";
        }
        return "<script>location.href='/customer/one2one';</script>";
    }

    @GetMapping("/one2one")
    public String one2one() {
        return "/customer/customer01";
    }

    @GetMapping("/customer02")
    @ResponseBody
    public String customer02(HttpSession session) {
        if (session.getAttribute("loginId") == null) {
            return "<script>alert('로그인을 해주세요'); location.href='/member/login';</script>";
        }

        return "<script>location.href='/customer/qna';</script>";
    }

    @GetMapping("/qna")
    public String qna() {
        return "/customer/customer2";
    }
}
