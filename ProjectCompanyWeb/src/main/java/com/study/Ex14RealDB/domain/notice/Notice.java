package com.study.Ex14RealDB.domain.notice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "company_notice")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeIdx;
    private String noticeTitle;
    private String noticeContent;
    private String noticeMemberId;
    private LocalDate noticeDate;


}
