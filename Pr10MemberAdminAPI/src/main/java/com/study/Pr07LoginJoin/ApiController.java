package com.study.Pr07LoginJoin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {

    final MemberRepository memberRepository;

    @PostMapping("/login")
    public ResDto login(@RequestBody LoginDto dto) {
        boolean isLoginOk = false;

        if (dto.getInputName().equals("admin") && dto.getInputPw().equals("1234")) {
            return ResDto.builder().status("ok").message("관리자").build();

        }

        for (Member m : MemberRepository.memberList) {
            if (m.getUsername().equals(dto.getInputName()) && m.getPassword().equals(dto.getInputPw())) {
                isLoginOk = true;
                break;
            }
        }
        if (isLoginOk) {
            return ResDto.builder()
                    .status("ok")
                    .message("로그인 성공!")
                    .build();
        } else {

            return ResDto.builder()
                    .status("fail")
                    .message("로그인 실패")
                    .build();
        }

    }

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

        if (isDulp) {
            return ResDto.builder()
                    .message("중복된 아이디가 있습니다.")
                    .build();
        } else {
            return ResDto.builder()
                    .message("사용 가능한 아이디입니다.")
                    .build();
        }

    }

    @PostMapping("/join")
    public ResDto join(@RequestBody JoinDto dto) {
        boolean isJoin = false;

        MemberRepository.memberList.add(Member.builder()
                .username(dto.getInputName()).password(dto.getInputPw()).email(dto.getInputEmail()).joindate(LocalDate.now())
                .build());
        return ResDto.builder()
                .status("ok")
                .message("회원가입 성공")
                .build();
    }

    @GetMapping("/memberList")
    public List<Member> memberList() {

        return MemberRepository.memberList;
    }

    @DeleteMapping("/member")
    public ResDto deleteMember(@RequestParam int index) {
        MemberRepository.memberList.remove(index);

        return ResDto.builder()
                .status("ok")
                .message("삭제 성공")
                .build();
    }

    @PutMapping("/member")
    public ResDto updateMember(@RequestBody UpdateDto dto) {
        System.out.println(dto.getIndex());
        System.out.println(dto.getInputEmail());
        MemberRepository.memberList.set(dto.getIndex(), Member.builder()
                        .username(dto.getInputName()).password(dto.getInputPw()).email(dto.getInputEmail()).joindate(dto.getInputJoindate())
                .build());
        return ResDto.builder()
                .status("ok")
                .message("수정 성공")
                .build();
    }
}
