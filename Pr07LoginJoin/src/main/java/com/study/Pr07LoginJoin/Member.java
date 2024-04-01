package com.study.Pr07LoginJoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}
