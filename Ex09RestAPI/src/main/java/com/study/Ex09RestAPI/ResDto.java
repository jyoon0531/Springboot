package com.study.Ex09RestAPI;

import lombok.Data;

@Data
public class ResDto {
    // {status : "ok", message : "로그인되었습니다."}   서버의 응답에 대응하는 객체
    private String status;
    private String message;
}
