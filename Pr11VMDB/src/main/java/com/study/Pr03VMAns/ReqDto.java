package com.study.Pr03VMAns;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReqDto {
    private int index;
    private String inputName;
    private int inputPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputLimitDate;
}
