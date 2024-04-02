package com.study.Ex12H2DB;

//데이타 모델링 클래스(데이타를 담고 있는)의 종류
//1. DTO 클래스 : Data Transfer Object, 데이타가 자주 바뀜. 로직(코드) 포함 안됨.
//             : 다른 계층간에 데이타 전송시 사용.
//2. VO 클래스 : View Object, 데이타가 안바뀜. 로직이 포함됨.
//            : 바뀌지 않는 데이타 보관시 사용.
//3. Entity 클래스 : DB 테이블 1:1 매칭, 로직(코드) 포함 안됨. JPA에서 사용.


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// @Entity : DB테이블과 1:1로 매칭되는 JPA 클래스에 사용함.
// @Table : 클래스명이 테이블명으로 기본 설정.
//          (name=)으로 따로 지정도 가능.
@Entity
@Table(name = "member")
// @Setter : 비추천 - Entity 객체에 set함수를 사용하면, 실제 DB 중복 적용함.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    // @Id : 기본키 id열로 사용한다는 의미
    @Id
    // @GeneratedValue : 해당 Id값을 어떻게 생성할지 전략을 선택한다.
    // 1. IDENTITY : MySQL, MariaDB, PostreSQL, H2DB
    // 2. SEQUENCE : Oracle, PostreSQL
    // 3. AUTO : 자동으로 선택함.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // biginit
    // @Column : DB열과 매칭 - 변수명과 DB 컬럼명이 다를 때 매칭해준다.
    @Column(name = "user_id")
    // DB필드 "user_id" -> "userId" 언더바 생략해서 매핑
    private String userId; // varchar
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role")
    private String userRole;
    @Column
    // @JsonFormat: @RequestBody @ResponseBody 매핑
    // @DateTimeFormat : @RequestParam @ModelAttribute 매핑
    //                   DB Date 데이터를 가져올 때, 형식화 해줌.
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;

    public void update(String userId, String userName, String userPw, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userRole = userRole;
    }
}
