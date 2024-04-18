package com.study.Ex14RealDB.domain.admin;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "company_member_admin")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;
    private String  memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private LocalDate memberJoinDate;
}
