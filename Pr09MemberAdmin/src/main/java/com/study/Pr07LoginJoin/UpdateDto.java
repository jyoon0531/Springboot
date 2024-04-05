package com.study.Pr07LoginJoin;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDto {
    private String inputName;
    private String inputPw;
    private String inputEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputJoindate;
    private int index;
}
