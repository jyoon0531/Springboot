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

    @PostMapping("/login")
    public String login(@RequestParam String inputName, @RequestParam String inputPw, Model model) {
        System.out.println(inputName);
        System.out.println(inputPw);

        if (inputName.equals("admin") && inputPw.equals("1234")) {
            model.addAttribute("list", MemberRepository.memberList);
            return "admin";
        }

        boolean isLoginOk = false;

        for (Member m : MemberRepository.memberList) {
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

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("list", MemberRepository.memberList);

        return "admin";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join";
    }

    @ResponseBody
    @PostMapping("/check")
    public ResDto checkDupl(@RequestBody ReqDto reqDto) {
        String inputName = reqDto.getInputName();
        System.out.println("inputName = " + inputName);
        boolean isDulp = false;
        for (Member m : MemberRepository.memberList) {
            if (m.getUsername().equals(inputName)) {
                isDulp = true;
                break;
            }
        }

        ResDto resDto = new ResDto();

        if (isDulp) {
            resDto.setMessage("중복된 아이디가 있습니다.");
        } else {
            resDto.setMessage("사용 가능한 아이디입니다.");
        }

        return resDto;
    }


    @PostMapping("/join")
    public String join(@ModelAttribute JoinDto joinDto) {
        MemberRepository.memberList.add(Member.builder()
                .username(joinDto.getInputName()).email(joinDto.getInputEmail()).password(joinDto.getInputPw()).joindate(LocalDate.now())
                .build());
        return "redirect:/";
    }

    @GetMapping("/update-form")
    public String updateForm(@RequestParam int index, Model model) {
        model.addAttribute("member", MemberRepository.memberList.get(index));
        model.addAttribute("index", index);
        return "modify";
    }

    @PostMapping("/update-action")
    @ResponseBody
    public String updateMember(@ModelAttribute UpdateDto dto) {
        System.out.println(dto.getIndex());
        MemberRepository.memberList.set(dto.getIndex(),
                Member.builder()
                        .username(dto.getInputName()).password(dto.getInputPw()).email(dto.getInputEmail()).joindate(dto.getInputJoindate())
                        .build()
        );

        return "<script>alert('수정되었습니다.'); location.href='/admin';</script>";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteMember(@RequestParam int index) {
        MemberRepository.memberList.remove(index);
        return "<script>alert('삭제되었습니다.'); location.href='/admin';</script>";
    }
}
