package com.study.Ex06Thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class Member {
    private String username;
    private String password;
}
