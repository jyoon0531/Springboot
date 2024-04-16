package com.study.Ex22TDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/api/v1/loginAction")
    public ResultDto loginAction(@RequestBody ReqDto reqDto) {
        Member member = Member.builder()
                            .loginId(reqDto.getLoginId())
                            .loginPw(reqDto.getLoginPw())
                            .build();
        int result = memberService.loginAction(member);
        ResultDto dto = new ResultDto();

        if (result == 1) {
            dto.setStatus("ok");
            dto.setMessage("로그인 성공!");
        } else {
            dto.setStatus("fail");
            dto.setMessage("로그인 실패!");
        }

        return dto;
    }

}
