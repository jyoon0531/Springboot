package com.study.Ex14RealDB.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    int countByMemberId(String memberId);

    Optional<Member> findByMemberId(String memberId);

    Optional<Member> findByMemberPw(String memberPw);

    Optional<Member> findByMemberPwAndMemberId(String memberPw, String memberId);

    Optional<Member> findByMemberNameAndMemberEmail(String memberName, String memberEmail);

    Optional<Member> findByMemberNameAndMemberEmailAndMemberId(String memberName, String memberEmail, String memberId);

    // 전체 검색

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberId(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id LIMIT 5", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id LIMIT 10", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_id DESC", nativeQuery = true)
    List<Member> searchByKeywordOrderByMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date LIMIT 5", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date LIMIT 10", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDate(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC", nativeQuery = true)
    List<Member> searchByKeywordOrderByJoinDateDesc(String keyword);

    // 아이디 검색
    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberId(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_id DESC", nativeQuery = true)
    List<Member> searchByMemberIdOrderByMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDate(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% ORDER BY m.member_join_date DESC", nativeQuery = true)
    List<Member> searchByMemberIdOrderByJoinDateDesc(String keyword);

    // 이름 검색

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberId(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_id DESC", nativeQuery = true)
    List<Member> searchByMemberNameOrderByMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDate(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword% ORDER BY m.member_join_date DESC", nativeQuery = true)
    List<Member> searchByMemberNameOrderByJoinDateDesc(String keyword);

    // 이메일 검색

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberId(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberIdLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberIdLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberIdDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberIdDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_id DESC", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByMemberIdDesc(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDateLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDateLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDate(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 5", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDateDescLimit5(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC LIMIT 10", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDateDescLimit10(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword% ORDER BY m.member_join_date DESC", nativeQuery = true)
    List<Member> searchByMemberEmailOrderByJoinDateDesc(String keyword);
}
