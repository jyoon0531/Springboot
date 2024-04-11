package com.study.Pr03VMAns;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddDto {
    private String inputName;
    private int inputPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputLimitDate;
}
