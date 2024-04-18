package com.study.Ex14RealDB.domain.one2one;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "company_one2one")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class One2one {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long one2oneIdx;
    private String one2oneName;
    private String one2onePhone;
    private String one2oneEmail;
    private String one2oneAddress;
    private String one2oneTitle;
    private String one2oneContent;
    private LocalDate one2oneDate;

    @Builder
    public One2one(String one2oneName, String one2onePhone, String one2oneAddress, String one2oneEmail,
                    String one2oneTitle, String one2oneContent) {
        this.one2oneName = one2oneName;
        this.one2onePhone = one2onePhone;
        this.one2oneEmail = one2oneEmail;
        this.one2oneAddress = one2oneAddress;
        this.one2oneTitle = one2oneTitle;
        this.one2oneContent = one2oneContent;
    }

}
