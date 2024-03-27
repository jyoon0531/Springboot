package com.study.Ex09RestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String main() {
        // 첫 화면 진입시 데이터 초기화
        Member member = new Member("hong", "1234", "abc@dot.com", LocalDate.now());
        // lombok에서 지원하는 기능, 매개변수를 자동완성으로 제안해준다
        Member member1 = Member.builder().username("hong").password("1234").email("abc@dot.com").joindate(LocalDate.now()).build();

        ApiController.memberList.add(member);

        return "login";     // login.html로 응답
    }

}
