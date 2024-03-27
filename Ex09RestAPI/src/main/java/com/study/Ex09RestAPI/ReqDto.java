package com.study.Ex09RestAPI;

import lombok.Data;

@Data
public class ReqDto {
    private String username;    // input의 name과 일치해야 함.
    private String password;
}
