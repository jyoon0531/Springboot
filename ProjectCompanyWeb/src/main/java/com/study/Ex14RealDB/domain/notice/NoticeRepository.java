package com.study.Ex14RealDB.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository  extends JpaRepository<Notice, Long> {
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword%", nativeQuery = true)
    List<Notice> searchByNoticeTitle(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword%", nativeQuery = true)
    List<Notice> searchByNoticeContent(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword%", nativeQuery = true)
    List<Notice> searchByNoticeMemberId(String keyword);


    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword%", nativeQuery = true)
    List<Notice> searchByKeyword(String keyword);

    @Query(value = "SELECT * FROM company_notice n ORDER BY n.notice_idx LIMIT 5", nativeQuery = true)
    List<Notice> findLimit5();

    @Query(value = "SELECT * FROM company_notice n ORDER BY n.notice_idx LIMIT 10", nativeQuery = true)
    List<Notice> findLimit10();

    @Modifying
    @Query(value = "UPDATE company_notice n SET n.notice_content = :noticeContent WHERE n.notice_idx = :noticeIdx", nativeQuery = true)
    int update(Long noticeIdx, String noticeContent);
}
