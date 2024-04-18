package com.study.Ex14RealDB.dto;

import com.study.Ex14RealDB.domain.one2one.One2one;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class One2oneSaveRequestDto {
    private String name;
    private String tel;
    private String email;
    private String address;
    private String title;
    private String desc;

    public One2one toEntity() {
        return One2one.builder()
                .one2oneName(name)
                .one2onePhone(tel)
                .one2oneEmail(email)
                .one2oneAddress(address)
                .one2oneTitle(title)
                .one2oneContent(desc)
                .build();
    }
}
