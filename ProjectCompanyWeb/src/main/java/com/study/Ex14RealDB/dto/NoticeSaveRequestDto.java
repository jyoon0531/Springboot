package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.notice.Notice;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeSaveRequestDto {
    private String noticeTitle;
    private String  editor4;
    private String noticeMemberId;

    public Notice toEntity() {
        return Notice.builder()
                .noticeContent(editor4)
                .noticeTitle(noticeTitle)
                .noticeMemberId(noticeMemberId)
                .build();
    }
}
