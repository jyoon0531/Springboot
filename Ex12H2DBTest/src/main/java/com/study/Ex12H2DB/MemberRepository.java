package com.study.Ex12H2DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

// @Repository : JPA DAO 클래스에 적용하고, @Component가 내부에 있음.
// @Service : 서비스 로직 클래스에 적용되고, @Component가 내부에 있음.
// @Controller : 컨트롤 인터페이스(HTTP 요청처리)를 구현하고, @Component가 내부에 있음.


// JpaRepository : 스프링 JPA 라이브러리에서 Entity에 대한 기본적인
//               : 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스다.
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // JpaRepository의 기본함수
    // 1. findAll() : SQL(SELECT * FROM TABLE)문을 실행한다.
    //             id값을 보고 없으면 추가, 있으면 수행한다.
    // 2. save() : SQL의 INSERT문과 UPDATE문을 실행한다.
    // 3. delete() : SQL delete문을 수행한다.

    // 쿼리 메소드
    // findBy컬럼명()
    // 예) findById((long)2) : SELECT * FROM member WHERE id=2
    // 예) findByUser_id("hong") : SELECT * FROM member WHERE user_id="hong"

    // SQL : SELECT * FROM MEMBER WHERE user_id = :userId
    List<MemberEntity> findByUserId(String userId);


    // And, Or를 메소드 이름에 추가할 수 있다.
    // OrderBy 필드명 Desc, Asc
    // First 5, Last 5 갯수 제한을 할 수 있다.
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userId, String userName);


    Boolean existsByJoindateLessThanEqual(LocalDate date);

    Long countByUserNameIgnoreCaseLike(String userId);

    // JPA에서 SQL을 사용하는 방법
    // 1. JPQL
    //  - 표준 ANSI SQL 문법을 지원함.
    //  - 특정 데이터베이스에 종속적인 기능은 지원하지 않음
    //  - from절 뒤에는 엔티티 클래스 이름을 넣어준다.(대소문자 구분함)
    @Query(value = "SELECT m FROM MemberEntity m WHERE m.userId = :userId")
    // table이 아니라 Entity를 사용함.
    List<MemberEntity> findByUserId_JPQL_Query(String userId);

    // 2. Native SQL
    //  - 특정 데이터베이스에 종속적인 기능을 제공한다.
    //    예) MySQL : LIMIT 5, NOW(), AUTO_INCREMENT
    //       Oracle : sysdate, 시퀀스
    //  Update, Insert, Delete문은 @Modifying @Transactional을 추가해야 됨.
    @Query(value = "SELECT * FROM member WHERE user_id = :userId", nativeQuery = true)
    List<MemberEntity> findByUserId_nativeQuery(String userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userId WHERE id = :id", nativeQuery = true)
    int updateById_nativeQuery(Long id, String userId);

    List<MemberEntity> findByUserPw(String userPw);

    @Query(value = "SELECT COUNT(*) FROM member WHERE joindate BETWEEN :startDate AND :endDate", nativeQuery = true)
    int findByJoindate_nativeSQL(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_name = :userName, user_pw = :userPw WHERE user_id = :userId", nativeQuery = true)
    int updateByUserId_nativeQuery(@Param("userName") String userName, @Param("userPw") String userPw, @Param("userId") String userId);

    Boolean existsByUserPw(String userPw);
}
