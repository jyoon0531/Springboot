package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.member.Member;
import com.study.Ex14RealDB.domain.notice.Notice;
import com.study.Ex14RealDB.domain.notice.NoticeRepository;
import com.study.Ex14RealDB.dto.MemberResponseDto;
import com.study.Ex14RealDB.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findAll() {
        List<Notice> list = noticeRepository.findAll();
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findById(Long no) {
        Optional<Notice> optional = noticeRepository.findById(no);
        if (optional.isPresent()) {
            return NoticeResponseDto.builder()
                    .noticeIdx(optional.get().getNoticeIdx())
                    .noticeMemberId(optional.get().getNoticeMemberId())
                    .noticeTitle(optional.get().getNoticeTitle())
                    .noticeContent(optional.get().getNoticeContent())
                    .noticeDate(optional.get().getNoticeDate())
                    .build();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByNoticeTitle(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitle(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByNoticeContent(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContent(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public boolean save(Notice entity) {
        Notice notice = noticeRepository.save(entity);
        return notice.getNoticeIdx() != 0;
    }

    @Transactional
    public boolean update(Long noticeIdx, String noticeContent) {
        int result = noticeRepository.update(noticeIdx, noticeContent);
        return result != 0;
    }

    // 전체 검색
    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberIdLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberIdLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberIdLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberIdLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberId(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberId(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberIdDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberIdDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberIdDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberIdDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeMemberIdDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeMemberIdDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDateLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDateLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDateLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDateLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDate(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDate(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDateDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDateDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDateDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDateDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeywordOrderByNoticeDateDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeywordOrderByNoticeDateDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    // 제목 검색
    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberIdLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberIdLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberIdLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberIdLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberId(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberId(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberIdDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberIdDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberIdDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberIdDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeMemberIdDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeMemberIdDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDateLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDateLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDateLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDateLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDate(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDate(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDateDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDateDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDateDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDateDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeTitleOrderByNoticeDateDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeTitleOrderByNoticeDateDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    // 내용 검색
    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberIdLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberIdLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberIdLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberIdLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberId(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberId(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberIdDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberIdDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberIdDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberIdDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeMemberIdDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeMemberIdDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDateLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDateLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDateLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDateLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDate(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDate(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDateDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDateDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDateDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDateDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeContentOrderByNoticeDateDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeContentOrderByNoticeDateDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    // 작성자 아이디 검색
    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberIdLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberIdLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberIdLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberIdLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberId(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberId(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeMemberIdDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeMemberIdDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDateLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDateLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDateLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDateLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDate(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDate(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDateDescLimit5(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDateDescLimit5(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDateDescLimit10(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDateDescLimit10(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
    public List<NoticeResponseDto> searchByNoticeMemberIdOrderByNoticeDateDesc(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberIdOrderByNoticeDateDesc(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
}
