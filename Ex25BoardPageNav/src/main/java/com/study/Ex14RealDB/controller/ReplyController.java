package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.dto.ReplySaveRequestDto;
import com.study.Ex14RealDB.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    final private ReplyService replyService;

    // "/writeReplyAction"
    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto,
                                   @RequestParam Long replyBoardIdx) {
        Long newReplyIdx = replyService.save(dto);

        boolean isFound = replyService.existsById(newReplyIdx);

        if (isFound) {
            return "<script>alert('댓글쓰기 성공'); location.href='/'; </script>";
        } else {
            return "<script>alert('댓글쓰기 실패'); location.href='/'; </script>";
        }

    }

    // deleteAction?replyIdx=1
    @GetMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam Long replyIdx,
                                @RequestParam Long boardIdx
                                ) {
        boolean isDeleted = replyService.deleteById(replyIdx);
        if (isDeleted) {
            return "<script>alert('댓글삭제 성공'); location.href='/board/contentForm?boardIdx=" + boardIdx + "';</script>";
        }
        return "<script>alert('댓글삭제 성공'); location.href='/'; </script>";

    }
}
