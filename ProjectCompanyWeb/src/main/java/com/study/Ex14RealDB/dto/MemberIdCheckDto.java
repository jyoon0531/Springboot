package com.study.Ex14RealDB.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberIdCheckDto {
    private String status;
    private String message;
}
