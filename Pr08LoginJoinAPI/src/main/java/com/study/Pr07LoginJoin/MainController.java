package com.study.Pr07LoginJoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


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
}
