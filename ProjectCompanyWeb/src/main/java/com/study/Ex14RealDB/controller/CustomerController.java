package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.domain.qna.Qna;
import com.study.Ex14RealDB.dto.One2oneSaveRequestDto;
import com.study.Ex14RealDB.dto.QnaResponseDto;
import com.study.Ex14RealDB.service.One2oneService;
import com.study.Ex14RealDB.service.QnaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final private One2oneService oneService;

    final private QnaService qnaService;

    @GetMapping("/customer01")
    public String one2one() {
        return "/customer/customer01";
    }

    @PostMapping("/insertOne2one")
    @ResponseBody
    public String insertOne2one(@ModelAttribute One2oneSaveRequestDto dto, @RequestParam String sample6_address, @RequestParam String sample6_detailAddress) {
        String address = sample6_address + " " + sample6_detailAddress;
        dto.setAddress(address);
        Long newIdx = oneService.save(dto);
        boolean isFound = oneService.existsById(newIdx);
        if (isFound) {
            return "<script>alert('1:1 문의글 등록 성공'); location.href='/';</script>";
        } else {
            return "<script>alert('1:1 문의글 등록 실패'); history.back();</script>";
        }
    }


    @GetMapping("/customer02")
    public String qna(Model model) {
        List<QnaResponseDto> list = qnaService.findAll();
        model.addAttribute("list", list);
        return "/customer/customer02";
    }

    @GetMapping("/searchQna")
    public String searchQna(@RequestParam String searchColumn, @RequestParam String searchKeyword, Model model) {
        System.out.println(searchColumn);
        System.out.println(searchKeyword);
        if (searchColumn.equals("qnaTitle")) {
            List<QnaResponseDto> list = qnaService.findByQnaTitle(searchKeyword);
            model.addAttribute("list", list);
        }
        if (searchColumn.equals("qnaContent")) {
            List<QnaResponseDto> list = qnaService.findByQnaContent(searchKeyword);
            model.addAttribute("list", list);

        }
        if (searchColumn.equals("qnaName")) {
            List<QnaResponseDto> list = qnaService.findByQnaName(searchKeyword);
            model.addAttribute("list", list);

        }
        model.addAttribute("selected", searchColumn);
        model.addAttribute("searchKeyword", searchKeyword);

        return "/customer/customer02";
    }

    @GetMapping("/customer02_3")
    public String customer02_3(@RequestParam Long no, Model model) {
        model.addAttribute("qnaIdx", no);
        return "/customer/customer02_3";
    }

    @PostMapping("/qnaCheckPw")
    @ResponseBody
    public String qnaCheckPw(@RequestParam String qnaPw, @RequestParam Long qnaIdx) {
        QnaResponseDto dto = qnaService.findById(qnaIdx);
        if (dto.getQnaPw().equals(qnaPw)) {
            return "<script>location.href='/customer/qnaDetail?no=" + dto.getQnaIdx() + "';</script>";
        }

        return "<script>alert('비밀번호가 일치하지 않습니다.'); history.back(); </script>";
    }

    @GetMapping("/qnaDetail")
    public String qnaDetail(@RequestParam Long no, Model model) {
        QnaResponseDto dto = qnaService.findById(no);
        model.addAttribute("qna", dto);

        return "/customer/customer02_4";
    }

    @GetMapping("/customer03")
    public String fqa() {
        return "/customer/customer03";
    }

}
