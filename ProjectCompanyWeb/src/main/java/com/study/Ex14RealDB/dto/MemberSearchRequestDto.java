package com.study.Ex14RealDB.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberSearchRequestDto {
    private String searchKeyword;
    private String searchSelect;
    private String orderSelect;
    private String pageSelect;
}
