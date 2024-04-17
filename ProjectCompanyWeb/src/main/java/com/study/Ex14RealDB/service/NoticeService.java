package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.notice.Notice;
import com.study.Ex14RealDB.domain.notice.NoticeRepository;
import com.study.Ex14RealDB.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
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
                    .noticeTitle(optional.get().getNoticeTitle())
                    .noticeContent(optional.get().getNoticeContent())
                    .noticeDate(optional.get().getNoticeDate())
                    .build();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findByNoticeTitle(String searchKeyword) {
        List<Notice> list = noticeRepository.findByNoticeTitle(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findByNoticeContent(String searchKeyword) {
        List<Notice> list = noticeRepository.findByNoticeContent(searchKeyword);
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }
}
