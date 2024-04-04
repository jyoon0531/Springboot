package com.study.Ex14RealDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
// @Setter : 자체 setter 메소드를 사용한다.
@AllArgsConstructor
@NoArgsConstructor  // @ModelAttribute @RequestBody 매핑 시 필요!
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String  userId;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")     // 나중에는 DTO로 가야 한다
    private LocalDate joinDate;

}
