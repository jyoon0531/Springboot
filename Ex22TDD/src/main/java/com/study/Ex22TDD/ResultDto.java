package com.study.Ex22TDD;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    // { "status" : "ok", "message" : "로그인 성공" }
    private String status;  // "ok" "fail"
    private String message; //
}
