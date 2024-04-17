package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.notice.Notice;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDto {
    private Long noticeIdx;
    private String noticeTitle;
    private String noticeContent;
    private LocalDate noticeDate;

    public NoticeResponseDto(Notice entity) {
        this.noticeIdx = entity.getNoticeIdx();
        this.noticeTitle = entity.getNoticeTitle();
        this.noticeContent = entity.getNoticeContent();
        this.noticeDate  = entity.getNoticeDate();
    }


}
