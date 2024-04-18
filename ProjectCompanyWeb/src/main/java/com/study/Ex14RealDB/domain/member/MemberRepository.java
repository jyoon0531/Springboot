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

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword%", nativeQuery = true)
    List<Member> searchByMemberId(String keyword);
    @Query(value = "SELECT * FROM company_member m WHERE m.member_name LIKE %:keyword%", nativeQuery = true)
    List<Member> searchByMemberName(String keyword);
    @Query(value = "SELECT * FROM company_member m WHERE m.member_email LIKE %:keyword%", nativeQuery = true)
    List<Member> searchByMemberEmail(String keyword);

    @Query(value = "SELECT * FROM company_member m WHERE m.member_id LIKE %:keyword% OR m.member_name LIKE %:keyword% OR m.member_email LIKE %:keyword%", nativeQuery = true)
    List<Member> searchByKeyword(String keyword);

    @Query(value = "SELECT * FROM company_member m ORDER BY m.member_idx LIMIT 5", nativeQuery = true)
    List<Member> findLimit5();

    @Query(value = "SELECT * FROM company_member m ORDER BY m.member_idx LIMIT 10", nativeQuery = true)
    List<Member> findLimit10();
}
