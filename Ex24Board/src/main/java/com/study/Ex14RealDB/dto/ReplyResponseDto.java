package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.reply.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReplyResponseDto {
    private Long replyIdx;
    private String replyName;
    private String replyContent;
    private LocalDateTime replyDate;
    private Long replyBoardIdx;

    public ReplyResponseDto(Reply entity) {
        this.replyIdx = entity.getReplyIdx();
        this.replyName = entity.getReplyName();
        this.replyContent = entity.getReplyContent();
        this.replyDate = entity.getReplyDate();
        this.replyBoardIdx = entity.getReplyBoardIdx();
    }
}
