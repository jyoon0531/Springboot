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

    // 전체 검색
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id LIMIT 5", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id LIMIT 10", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberId(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date LIMIT 5", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date LIMIT 10", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDate(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% OR n.notice_content LIKE %:keyword% OR n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC", nativeQuery = true)
    List<Notice> searchByKeywordOrderByNoticeDateDesc(String keyword);

    // 제목 검색
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberId(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_member_id DESC", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDate(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_title LIKE %:keyword% ORDER BY notice_date DESC", nativeQuery = true)
    List<Notice> searchByNoticeTitleOrderByNoticeDateDesc(String keyword);

    // 내용 검색
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberId(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_member_id DESC", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDate(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_content LIKE %:keyword% ORDER BY notice_date DESC", nativeQuery = true)
    List<Notice> searchByNoticeContentOrderByNoticeDateDesc(String keyword);

    // 작성자 아이디 검색
    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberId(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_member_id DESC", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDate(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC LIMIT 5", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC LIMIT 10", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_notice n WHERE n.notice_member_id LIKE %:keyword% ORDER BY notice_date DESC", nativeQuery = true)
    List<Notice> searchByNoticeMemberIdOrderByNoticeDateDesc(String keyword);
}
