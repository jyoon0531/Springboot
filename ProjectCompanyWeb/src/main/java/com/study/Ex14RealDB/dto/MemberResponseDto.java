package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.member.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String memberId;
    private String memberName;
    private String memberEmail;
    private LocalDate memberBirthDate;
    private LocalDate memberJoinDate;

    public MemberResponseDto(Member entity) {
        this.memberId = entity.getMemberId();
        this.memberName = entity.getMemberName();
        this.memberEmail = entity.getMemberEmail();
        this.memberBirthDate = entity.getMemberBirthDate();
        this.memberJoinDate = entity.getMemberJoinDate();
    }

}
