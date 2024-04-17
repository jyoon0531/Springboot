package com.study.Ex14RealDB.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository  extends JpaRepository<Notice, Long> {
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword%", nativeQuery = true)
    List<Notice> findByNoticeTitle(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword%", nativeQuery = true)
    List<Notice> findByNoticeContent(String keyword);
}
