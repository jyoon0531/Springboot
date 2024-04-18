package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.domain.member.Member;
import com.study.Ex14RealDB.dto.MemberIdCheckDto;
import com.study.Ex14RealDB.dto.MemberIdCheckRequestDto;
import com.study.Ex14RealDB.dto.MemberResponseDto;
import com.study.Ex14RealDB.dto.MemberSaveRequestDto;
import com.study.Ex14RealDB.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/loginAction")
    @ResponseBody
    public String loginAction(HttpSession session, @RequestParam String loginId, @RequestParam String loginPw) {
        boolean findId = memberService.findByMemberId(loginId);
        if (!findId) {
            return "<script>alert('아이디가 존재하지 않습니다.'); history.back(); </script>";
        }

        boolean findPw = memberService.findByMemberPw(loginPw);
        if (!findPw) {
            return "<script>alert('비밀번호가 다릅니다.'); history.back(); </script>";
        }

        MemberResponseDto member = memberService.findByMemberPwAndMemberId(loginPw, loginId);
        session.setAttribute("loginId", member.getMemberId());

        return "<script>alert('로그인되었습니다.'); location.href='/'; </script>";
    }

    @GetMapping("/join")
    public String join() {
        return "/member/join2";
    }

    @PostMapping("/checkIdDuplicate")
    @ResponseBody
    public MemberIdCheckDto checkIdDuplicate(@RequestBody MemberIdCheckRequestDto dto) {
        System.out.println(dto.getInputId());
        boolean isDuplicate = memberService.findByMemberId(dto.getInputId());

        if (isDuplicate) {
            return MemberIdCheckDto.builder()
                    .status("fail")
                    .message("아이디가 중복됩니다.")
                    .build();
        } else {
            return MemberIdCheckDto.builder()
                    .status("ok")
                    .message("아이디 사용가능합니다.")
                    .build();
        }
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberSaveRequestDto dto) {
        Long newIdx = memberService.save(dto);

        boolean isFound = memberService.existsById(newIdx);

        if (isFound) {
            return "<script>alert('회원가입 성공'); location.href='/'; </script>";
        } else {
            return "<script>alert('회원가입 실패'); history.back(); </script>";
        }

    }

    @GetMapping("/idFind")
    public String idFind() {
        return "member/idFind";
    }

    @PostMapping("/idFindAction")
    public String idFindAction(@RequestParam String userName, @RequestParam String userEmail, Model model) {
        String result = memberService.findByMemberNameAndMemberEmail(userName, userEmail);

        model.addAttribute("userId", result);

        return "/member/idFind";
    }

    @GetMapping("/passwordFind")
    public String passwordFind() {
        return "member/passwordFind";
    }

    @PostMapping("/passwordFindAction")
    public String passwordFindAction(@RequestParam String userName, @RequestParam String userEmail, @RequestParam String userId, Model model) {
        String result = memberService.findByMemberNameAndMemberEmailAndMemberId(userName, userEmail, userId);
        model.addAttribute("userPw", result);
        return "/member/passwordFind";
    }
}
