package com.study.Ex22TDD;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String loginId;
    private String loginPw;
}
