package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private int emailReceive;
    private int pwCheckQuestion;
    private String pwCheckAnswer;
    private String userGender;
    private LocalDate userBirthday;


    public Member toEntity() {
        return Member.builder()
                .memberId(userId)
                .memberPw(userPw)
                .memberName(userName)
                .memberEmail(userEmail)
                .memberEmailReceive(emailReceive)
                .memberPwQuestion(pwCheckQuestion)
                .memberPwAnswer(pwCheckAnswer)
                .memberGender(userGender)
                .memberBirthDate(userBirthday)
                .build();
    }
}
