package com.study.Ex14RealDB.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
