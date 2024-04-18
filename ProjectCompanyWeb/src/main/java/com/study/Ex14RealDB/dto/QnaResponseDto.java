package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.qna.Qna;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaResponseDto {
    private Long qnaIdx;
    private String qnaName;
    private String qnaPw;
    private String qnaTitle;
    private String qnaContent;
    private LocalDate qnaDate;

    public QnaResponseDto(Qna entity) {
        this.qnaIdx = entity.getQnaIdx();
        this.qnaName = entity.getQnaName();
        this.qnaPw = entity.getQnaPw();
        this.qnaTitle = entity.getQnaTitle();
        this.qnaContent = entity.getQnaContent();
        this.qnaDate = entity.getQnaDate();
    }
}
