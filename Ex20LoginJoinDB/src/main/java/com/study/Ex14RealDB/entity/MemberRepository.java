package com.study.Ex14RealDB.entity;

import com.study.Ex14RealDB.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 기본 메소드
    // 1. findAll()
    // 2. findById()
    // 3. count() : COUNT(*)
    // 4. save() : UPDATE, INSERT
    // 5. delete() : DELETE

    // 쿼리 메소드, JPQL, NativeSQL 아래에 등록한다.
    @Query(value = "SELECT * FROM member m WHERE m.user_id = :userId AND m.user_pw = :userPw", nativeQuery = true )
    Optional<MemberEntity> findByUserIdAndUserPw(String userId, String userPw);

    @Query(value = "SELECT * FROM member m WHERE m.user_id = :userId", nativeQuery = true)
    Optional<MemberEntity> findByUserId(String userId);

}
