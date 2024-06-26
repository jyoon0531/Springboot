package com.study.Ex14RealDB.controller;

import com.study.Ex14RealDB.dto.*;
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

    //    @GetMapping("/searchMember")
    @PostMapping("/searchMember")
    public String searchMember(@ModelAttribute MemberSearchRequestDto dto, Model model) {
        String searchKeyword = dto.getSearchKeyword();
        String searchSelect = dto.getSearchSelect();
        String orderSelect = dto.getOrderSelect();
        String pageSelect = dto.getPageSelect();
        List<MemberResponseDto> list = null;
        // 전체 검색
        if (searchSelect.equals("all")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByKeywordOrderByMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByKeywordOrderByMemberIdLimit10(searchKeyword);
                } else {
                    list = memberService.searchByKeywordOrderByMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByKeywordOrderByMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByKeywordOrderByMemberIdDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByKeywordOrderByMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByKeywordOrderByJoinDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByKeywordOrderByJoinDateLimit10(searchKeyword);
                } else {
                    list = memberService.searchByKeywordOrderByJoinDate(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByKeywordOrderByJoinDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByKeywordOrderByJoinDateDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByKeywordOrderByJoinDateDesc(searchKeyword);
                }
            }
        }
        // 아이디 검색
        if (searchSelect.equals("id")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberIdOrderByMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberIdOrderByMemberIdLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberIdOrderByMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberIdOrderByMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberIdOrderByMemberIdDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberIdOrderByMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberIdOrderByJoinDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberIdOrderByJoinDateLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberIdOrderByJoinDate(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberIdOrderByJoinDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberIdOrderByJoinDateDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberIdOrderByJoinDateDesc(searchKeyword);
                }
            }
        }

        // 이름 검색
        if (searchSelect.equals("name")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberNameOrderByMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberNameOrderByMemberIdLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberNameOrderByMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberNameOrderByMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberNameOrderByMemberIdDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberNameOrderByMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberNameOrderByJoinDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberNameOrderByJoinDateLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberNameOrderByJoinDate(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberNameOrderByJoinDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberNameOrderByJoinDateDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberNameOrderByJoinDateDesc(searchKeyword);
                }
            }
        }
        // 이메일 검색
        if (searchSelect.equals("email")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberEmailOrderByMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberEmailOrderByMemberIdLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberEmailOrderByMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberEmailOrderByMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberEmailOrderByMemberIdDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberEmailOrderByMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberEmailOrderByJoinDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberEmailOrderByJoinDateLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberEmailOrderByJoinDate(searchKeyword);
                }
            }
            if (orderSelect.equals("joinDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = memberService.searchByMemberEmailOrderByJoinDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = memberService.searchByMemberEmailOrderByJoinDateDescLimit10(searchKeyword);
                } else {
                    list = memberService.searchByMemberEmailOrderByJoinDateDesc(searchKeyword);
                }
            }
        }
        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("searchSelected", searchSelect);
        model.addAttribute("orderSelected", orderSelect);
        model.addAttribute("pageSelected", pageSelect);

        return "/admin/admin_member";
    }

    @GetMapping("/adminNotice")
    public String adminNotice(Model model) {
        List<NoticeResponseDto> list = noticeService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("size", list.size());
        return "/admin/admin_notice";
    }

    @PostMapping("/searchNotice")
    public String searchNotice(@ModelAttribute NoticeSearchRequestDto dto, Model model) {
        String searchKeyword = dto.getSearchKeyword();
        String searchSelect = dto.getSearchSelect();
        String orderSelect = dto.getOrderSelect();
        String pageSelect = dto.getPageSelect();

        List<NoticeResponseDto> list = null;
        // 전체 검색
        if (searchSelect.equals("all")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByKeywordOrderByNoticeMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByKeywordOrderByNoticeMemberIdLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByKeywordOrderByNoticeMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByKeywordOrderByNoticeMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByKeywordOrderByNoticeMemberIdDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByKeywordOrderByNoticeMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByKeywordOrderByNoticeDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByKeywordOrderByNoticeDateLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByKeywordOrderByNoticeDate(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByKeywordOrderByNoticeDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByKeywordOrderByNoticeDateDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByKeywordOrderByNoticeDateDesc(searchKeyword);
                }
            }
        }

        // 제목 검색
        if (searchSelect.equals("title")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberIdLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberIdDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeTitleOrderByNoticeMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDateLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDate(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDateDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeTitleOrderByNoticeDateDesc(searchKeyword);
                }
            }
        }

        // 내용 검색
        if (searchSelect.equals("content")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberIdLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberIdDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeContentOrderByNoticeMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeDateLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeContentOrderByNoticeDate(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeContentOrderByNoticeDateDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeContentOrderByNoticeDateDesc(searchKeyword);
                }
            }
        }

        // 작성자 아이디 검색
        if (searchSelect.equals("id")) {
            if (orderSelect.equals("idAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberIdLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberIdLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberId(searchKeyword);
                }
            }
            if (orderSelect.equals("idDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeMemberIdDesc(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateAsc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDateLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDateLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDate(searchKeyword);
                }
            }
            if (orderSelect.equals("regDateDesc")) {
                if (pageSelect.equals("page5")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDateDescLimit5(searchKeyword);
                } else if (pageSelect.equals("page10")) {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDateDescLimit10(searchKeyword);
                } else {
                    list = noticeService.searchByNoticeMemberIdOrderByNoticeDateDesc(searchKeyword);
                }
            }
        }

        int size = list != null ? list.size() : 0;
        model.addAttribute("list", list);
        model.addAttribute("size", size);
        model.addAttribute("searchSelect", searchSelect);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("orderSelected", orderSelect);
        model.addAttribute("pageSelected", pageSelect);
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
            return "<script>alert('공지사항 수정 성공'); location.href='/admin/adminNotice';</script>";
        } else {
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
            return "<script>alert('공지사항 등록 성공'); location.href='/admin/adminNotice';</script>";
        } else {
            return "<script>alert('공지사항 등록 실패'); history.back();</script>";
        }
    }
}
