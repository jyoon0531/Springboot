package com.study.Pr07LoginJoin;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
@Data
public class MemberRepository {
    public static List<Member> memberList = new ArrayList<>();

}
