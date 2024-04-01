package com.study.Pr07LoginJoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    List<Member> memberList = new ArrayList<>();

    @GetMapping("/")
    public String main() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String inputName, @RequestParam String inputPw, Model model) {
        System.out.println(inputName);
        System.out.println(inputPw);

        boolean isLoginOk = false;

        for (Member m : memberList) {
            if (m.getUsername().equals(inputName) && m.getPassword().equals(inputPw)) {
                isLoginOk = true;
                break;
            }
        }

        if (isLoginOk) {
            model.addAttribute("message", "로그인 성공!");
        }

        return "login";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam String inputName, @RequestParam String inputEmail, @RequestParam String inputPw, Model model) {
        memberList.add(new Member(inputName, inputPw, inputEmail, LocalDate.now()));
//        model.addAttribute("")

        return "login";
    }

    @ResponseBody
    @PostMapping("/check")
    public ResDto checkDupl(@RequestBody ReqDto reqDto, Model model) {
        String inputName = reqDto.getInputName();
        System.out.println("inputName = " + inputName);
        boolean isDulp = false;
        for (Member m : memberList) {
            if (m.getUsername().equals(inputName)) {
                isDulp = true;
                break;
            }
        }

        ResDto resDto = new ResDto();

        if (isDulp) {
            resDto.setMessage("중복된 아이디입니다.");
            model.addAttribute("status", "중복");
        } else {
            resDto.setMessage("사용 가능한 아이디입니다.");
            model.addAttribute("status", "사용가능");
        }

        return resDto;
    }

    @GetMapping("/check")
    public String forwardJoin() {
        return "forward:/join";
    }
}
