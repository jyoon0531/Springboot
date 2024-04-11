package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// html입력폼 <-> DTO <-> DAO(Entity) <-> Repository <-> DB
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDto {
    @NotBlank
    private Long id = Long.valueOf(0L);
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈 문자열, 스페이스 문자열만 넣을 수 없습니다.")
    private String userId;
    @Size(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈 문자열, 스페이스 문자열만 넣을 수 없습니다.")
    private String userPw;

    private String userName;

    private String userRole;
    private String userAddress;     // 입력폼에는 있고, DB에는 없는 컬럼
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    // DTO를 save용 Entity로 변화해주는 메소드
    public MemberEntity toSaveEntity() {
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }

    // DTO를 update용 Entity로 변환해주는 메소드
    public MemberEntity toUpdateEntity() {
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }


}
