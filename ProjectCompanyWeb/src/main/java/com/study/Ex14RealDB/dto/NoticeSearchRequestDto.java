package com.study.Ex14RealDB.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeSearchRequestDto {
    private String searchSelect;
    private String searchKeyword;
    private String orderSelect;
    private String pageSelect;
}
