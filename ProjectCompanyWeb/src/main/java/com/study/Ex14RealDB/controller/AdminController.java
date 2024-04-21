package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.dto.MemberResponseDto;
import com.study.Ex14RealDB.dto.MemberSearchRequestDto;
import com.study.Ex14RealDB.dto.NoticeResponseDto;
import com.study.Ex14RealDB.dto.NoticeSaveRequestDto;
import com.study.Ex14RealDB.service.AdminMemberService;
import com.study.Ex14RealDB.service.MemberService;
import com.study.Ex14RealDB.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminMemberService adminService;
    private final MemberService memberService;
    private final NoticeService noticeService;

    @GetMapping("")
    public String adminLogin() {
        return "/admin/admin_login";
    }

    @PostMapping("/adminLoginAction")
    public String adminLoginAction(@RequestParam String memberId, @RequestParam String memberPw, HttpSession session) {
        boolean isAdmin = adminService.findByMemberIdAndMemberPw(memberId, memberPw);
        if (isAdmin) {
            session.setAttribute("adminId", memberId);
            return "redirect:/admin/adminMember";
        } else {
            return "redirect:/admin";
        }
    }

    @GetMapping("/adminMember")
    public String adminMember(Model model) {
        List<MemberResponseDto> list = memberService.findAll();
        model.addAttribute("list", list);
        long size = memberService.count();
        model.addAttribute("size", size);
        return "admin/admin_member";
    }

    @GetMapping("/searchMember")
//    public String searchMember(@RequestParam String searchSelect, @RequestParam String searchKeyword, Model model) {
    public String searchMember(@ModelAttribute MemberSearchRequestDto dto, Model model) {
        String searchKeyword = dto.getSearchKeyword();
        String searchSelect = dto.getSearchSelect();
        System.out.println(dto.getOrderSelect());
        List<MemberResponseDto> list = null;
        if (searchSelect.equals("all")) {
            list = memberService.searchByKeyword(searchKeyword);
        }
        if (searchSelect.equals("id")) {
            list = memberService.searchByMemberId(searchKeyword);
        }
        if (searchSelect.equals("name")) {
            list = memberService.searchByMemberName(searchKeyword);
        }
        if (searchSelect.equals("email")) {
            list = memberService.searchByMemberEmail(searchKeyword);
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("searchKeyword", searchKeyword);

        return "/admin/admin_member";
    }

    @GetMapping("/sortMember/searchMember")
    public String sortMemberWithSearchKeyword() {
        return "/admin/admin_member";
    }

    @GetMapping("/sortMember")
//    public String sortMember(@RequestParam String orderSelect, Model model) {
    public String sortMember(@ModelAttribute MemberSearchRequestDto dto, Model model) {
        String orderSelect = dto.getOrderSelect();  // 정렬 기준 : idAsc, idDesc, joinDateAsc, joinDateDesc
        String searchKeyword = dto.getSearchKeyword();  // 검색어
        String searchSelect = dto.getSearchSelect();    // 검색 기준 : all, id, name, email
        List<MemberResponseDto> list = null;
        if (orderSelect.equals("idAsc")) {
            list = memberService.sortOrderByMemberId();
//            list = memberService.findByMemberIdContainingOrderByMemberId(searchKeyword);
        }

        if (orderSelect.equals("idDesc")) {
            list = memberService.sortOrderByMemberIdDesc();
        }
        if (orderSelect.equals("joinDateAsc")) {
            list = memberService.sortOrderByMemberJoinDate();
        }
        if (orderSelect.equals("joinDateDesc")) {
            list = memberService.sortOrderByMemberJoinDateDesc();
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("selected", orderSelect);
        model.addAttribute("searchKeyword", searchKeyword);
        return "/admin/admin_member";
    }

    @GetMapping("/pageMember")
    public String pageMember(@RequestParam String pageSelect,@RequestParam String orderSelect, Model model) {
        List<MemberResponseDto> list = null;
        if (pageSelect.equals("page5")) {
            list = memberService.findLimit5();
        }
        if (pageSelect.equals("page10")) {
            list = memberService.findLimit10();
        }
        if (pageSelect.equals("pageAll")) {
            list = memberService.findAll();
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("selected", pageSelect);
        return "/admin/admin_member";
    }


    @GetMapping("/adminNotice")
    public String adminNotice(Model model) {
        List<NoticeResponseDto> list = noticeService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("size", list.size());
        return "/admin/admin_notice";
    }

    @GetMapping("/searchNotice")
    public String searchNotice(@RequestParam String searchSelect, @RequestParam String searchKeyword, Model model) {
        List<NoticeResponseDto> list = null;
        if (searchSelect.equals("all")) {
            list = noticeService.searchByKeyword(searchKeyword);
        }
        if (searchSelect.equals("title")) {
            list = noticeService.searchByNoticeTitle(searchKeyword);
        }
        if (searchSelect.equals("content")) {
            list = noticeService.searchByNoticeContent(searchKeyword);
        }
        if (searchSelect.equals("id")) {
            list = noticeService.searchByNoticeMemberId(searchKeyword);
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        return "/admin/admin_notice";
    }

    @GetMapping("/sortNotice")
    public String sortNotice(@RequestParam String orderSelect, Model model) {
        List<NoticeResponseDto> list = null;
        if (orderSelect.equals("idAsc")) {
            list = noticeService.sortOrderByNoticeMemberId();
        }
        if (orderSelect.equals("idDesc")) {
            list = noticeService.sortOrderByNoticeMemberIdDesc();
        }
        if (orderSelect.equals("regDateAsc")) {
            list = noticeService.sortOrderByNoticeDate();
        }
        if (orderSelect.equals("regDateDesc")) {
            list = noticeService.sortOrderByNoticeDateDesc();
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("selected", orderSelect);

        return "/admin/admin_notice";
    }

    @GetMapping("/pageNotice")
    public String pageNotice(@RequestParam String pageSelect, Model model) {
        List<NoticeResponseDto> list = null;
        if (pageSelect.equals("page5")) {
            list = noticeService.findLimit5();
        }
        if (pageSelect.equals("page10")) {
            list = noticeService.findLimit10();
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("selected", pageSelect);

        return "/admin/admin_notice";
    }

    @GetMapping("/modifyNotice")
    public String modifyNotice(@RequestParam Long noticeIdx, Model model) {
        NoticeResponseDto dto = noticeService.findById(noticeIdx);
        model.addAttribute("notice", dto);
        return "/admin/admin_notice_view";
    }

    @PostMapping("/modifyNoticeAction")
    @ResponseBody
    public String modifyNoticeAction(@RequestParam Long noticeIdx, @RequestParam String editor4) {
        boolean isUpdate = noticeService.update(noticeIdx, editor4);
        if (isUpdate) {
            return "<script>alert('공지사항 수정 성공'); location.href='/adminNotice';</script>";
        }else {
            return "<script>alert('공지사항 수정 실패'); history.back();</script>";
        }
    }

    @GetMapping("/writeNotice")
    public String writeNotice() {
        return "/admin/admin_notice_write";
    }

    @PostMapping("/insertNotice")
    @ResponseBody
    public String insertNotice(@ModelAttribute NoticeSaveRequestDto dto, HttpSession session) {
        String adminId = (String) session.getAttribute("adminId");
        dto.setNoticeMemberId(adminId);
        boolean isInsert = noticeService.save(dto.toEntity());
        if (isInsert) {
            return "<script>alert('공지사항 등록 성공'); location.href='/adminNotice';</script>";
        }else {
            return "<script>alert('공지사항 등록 실패'); history.back();</script>";
        }
    }
}
