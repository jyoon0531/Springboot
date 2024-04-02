package com.study.Ex12H2DB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model) {
        memberRepository.save(new MemberEntity(1L, "hong", "1234", "홍길동", "ROlE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(2L, "tom", "1234", "톰아저씨", "ROlE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(3L, "admin", "1234", "관리자", "ROlE_ADMIN", LocalDate.now()));

        List<MemberEntity> list = memberRepository.findAll();
        for (MemberEntity m : list) {
            System.out.println(m.getUserName());
        }

        model.addAttribute("list", list);


        return "index";
    }
}
