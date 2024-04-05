package com.study.Pr03VMAns;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResDto {
    private String status;
    private String message;
    private int count;
}
