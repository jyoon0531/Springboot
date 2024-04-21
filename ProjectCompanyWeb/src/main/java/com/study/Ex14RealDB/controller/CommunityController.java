package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.dto.NoticeResponseDto;
import com.study.Ex14RealDB.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

    final private NoticeService noticeService;

    @GetMapping("/community01")
    public String community01(Model model) {
        List<NoticeResponseDto> list = noticeService.findAll();
        model.addAttribute("list", list);
        return "/community/community01";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(@RequestParam Long no, Model model) {
        NoticeResponseDto notice = noticeService.findById(no);
        model.addAttribute("notice", notice);
        return "/community/community01_1";
    }

    @GetMapping("/searchNotice")
    public String search(@RequestParam String searchKeyword, @RequestParam String searchColumn, Model model) {
        System.out.println(searchKeyword);
        System.out.println(searchColumn);
        if (searchColumn.equals("noticeTitle")) {
            List<NoticeResponseDto> list = noticeService.searchByNoticeTitle(searchKeyword);
            model.addAttribute("list", list);
        }
        if (searchColumn.equals("noticeContent")) {
            List<NoticeResponseDto> list = noticeService.searchByNoticeContent(searchKeyword);
            model.addAttribute("list", list);
        }
        model.addAttribute("selected", searchColumn);
        model.addAttribute("searchKeyword", searchKeyword);

        return "/community/community01";
    }
}
