package com.study.Ex14RealDB.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "company_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private int memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    private LocalDate memberBirthDate;
    private LocalDate memberJoinDate;

    @Builder
    public Member(String memberId, String memberPw,String memberName, String memberEmail, int memberEmailReceive,
                int memberPwQuestion, String memberPwAnswer, String memberGender, LocalDate memberBirthDate
                ) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberBirthDate = memberBirthDate;
        this.memberJoinDate = LocalDate.now();
    }

}
