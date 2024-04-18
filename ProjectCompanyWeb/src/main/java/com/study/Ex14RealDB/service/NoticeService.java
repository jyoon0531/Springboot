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

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByKeyword(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByKeyword(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchByNoticeMemberId(String searchKeyword) {
        List<Notice> list = noticeRepository.searchByNoticeMemberId(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> sortOrderByNoticeMemberId() {
        Sort sort = Sort.by(Sort.Direction.ASC, "noticeMemberId");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> sortOrderByNoticeMemberIdDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "noticeMemberId");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> sortOrderByNoticeDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "noticeDate");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> sortOrderByNoticeDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "noticeDate");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findLimit5() {
        List<Notice> list = noticeRepository.findLimit5();
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findLimit10() {
        List<Notice> list = noticeRepository.findLimit10();
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
}
