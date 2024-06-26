package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.dto.MemberLoginDto;
import com.study.Ex14RealDB.dto.MemberJoinDto;
import com.study.Ex14RealDB.entity.MemberRepository;
import com.study.Ex14RealDB.entity.MemberEntity;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    // 생성자 주입
    final MemberRepository memberRepository;

    @GetMapping("/")
    public String main() {

        return "index";     // index.html로 응답
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/loginAction")
    @ResponseBody
    public String loginAction(@Valid MemberLoginDto dto, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            // 바인딩 오류
            // DTO에 설정한 message 값을 가져온다
            String detail = bindingResult.getFieldError().getDefaultMessage();

            String code = bindingResult.getFieldError().getCode();
            System.out.println(detail + ":" + code);

            return "<script>alert('"+detail+"'); history.back(); </script>";
        }

        System.out.println(dto.getUserId());
        System.out.println(dto.getUserPw());

        // 로그인 처리 로직
        // 1. "아이디가 없습니다."
        // 2. "암호가 맞지 않습니다."
        Optional<MemberEntity> optional = memberRepository.findByUserId(dto.getUserId());
        if (!optional.isPresent()){
            return "<script>alert('아이디가 없습니다.'); history.back(); </script>";
        }

        Optional<MemberEntity> optional2 = memberRepository.findByUserIdAndUserPw(dto.getUserId(), dto.getUserPw());

        if (!optional2.isPresent()) {
            return "<script>alert('암호가 맞지 않습니다.'); history.back(); </script>";
        }

        // 세션에 로그인 여부/로그인 정보(아이디, 권한) 저장
        session.setAttribute("isLogin", true);
        session.setAttribute("userId", optional2.get().getUserId());
        session.setAttribute("userRole", optional2.get().getUserRole());

        String userRole = optional2.get().getUserRole();
        if (userRole.equals("ROLE_ADMIN")) {
            return "<script>alert('관리자 로그인 성공'); location.href='/admin';</script>";
        }

        return "<script>alert('로그인 성공'); location.href='/';</script>";
    }

    @GetMapping("/logoutAction")
    @ResponseBody
    public String logoutAction(HttpSession session) {
        // 로그아웃 액션
        session.setAttribute("isLogin", null);
        session.setAttribute("userId", null);
        session.setAttribute("userRole", null);

        session.invalidate();   // 세션종료 (JSESSIONID 종료), 모든 속성 제거됨.

        return "<script>alert('로그아웃되었습니다.'); location.href='/';</script>";
    }

    @RequestMapping("/admin")
    public String list(Model model) {
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);
        System.out.println("size: " + list.size());
        model.addAttribute("listcount", memberRepository.count());
        return "admin";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @ResponseBody
    @PostMapping("/joinAction")
    public String joinAction(@Valid @ModelAttribute MemberJoinDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            // 바인딩 오류
            // DTO에 설정한 message 값을 가져온다
            String detail = bindingResult.getFieldError().getDefaultMessage();

            String code = bindingResult.getFieldError().getCode();
            System.out.println(detail + ":" + code);

            return "<script>alert('"+detail+"'); history.back(); </script>";
        }

        System.out.println(dto.toString());
        try {
            MemberEntity memberEntity = dto.toSaveEntity();
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패'); history.back();</script>";
        }
        System.out.println("회원가입 성공!");
        return "<script>alert('회원가입 성공!');location.href='/';</script>";
    }

    @GetMapping("/viewMember")
    public String viewMember(@RequestParam Long id, Model model) {
        Optional<MemberEntity> optional = memberRepository.findById(id);
        if (!optional.isPresent()) {
            System.out.println("회원정보가 없습니다.");
            return "redirect:/list";
        }

        optional.ifPresent(memberEntity -> {
            model.addAttribute("member", memberEntity.toSaveDto());
        });

        return "modifyForm";
    }

    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberJoinDto dto) {
        try {
            MemberEntity memberEntity = dto.toUpdateEntity();
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원정보수정 실패");
            return "<script>alert('회원정보수정 실패'); history.back();</script>";
        }
        System.out.println("회원정보수정 성공!");
        return "<script>alert('회원정보수정 성공!'); location.href='/admin';</script>";
    }

    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam Long id) {
        Optional<MemberEntity> optional = memberRepository.findById(id);
        if (!optional.isPresent()) {
            System.out.println("회원정보조회 실패");
            return "<script>alert('회원정보조회 실패'); location.href='/admin';</script>";
        }

        MemberEntity memberEntity = optional.get();
        try {
            memberRepository.delete(memberEntity);
        } catch (Exception e) {
            e.printStackTrace();

            return "<script>alert('회원정보삭제 실패'); history.back();</script>";
        }

        return "<script>alert('회원정보삭제 성공!'); location.href='/admin';</script>";
    }
}
