package com.study.Ex12H2DB;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository : 스프링 JPA 라이브러리에서 Entity에 대한 기본적인
//               : 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스다.
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // JpaRepository의 기본함수
    // 1. findAll() : SQL(SELECT * FROM TABLE)문을 실행한다.
    // 2. findBy컬럼명()
    // 예) findById((long)2) : SELECT * FROM member WHERE id=2
    // 예) findByUser_id("hong") : SELECT * FROM member WHERE user_id="hong"
    // 3. save() : SQL의 INSERT문과 UPDATE문을 실행한다.
    //             id값을 보고 없으면 추가, 있으면 수행한다.
    // 4. delete() : SQL delete문을 수행한다.

}
