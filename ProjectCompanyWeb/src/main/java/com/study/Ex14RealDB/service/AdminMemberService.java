package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.admin.AdminMember;
import com.study.Ex14RealDB.domain.admin.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminMemberService {
    private final AdminMemberRepository adminMemberRepository;
    @Transactional(readOnly = true)
    public boolean findByMemberIdAndMemberPw(String memberId, String memberPw) {
        Optional<AdminMember> optional = adminMemberRepository.findByMemberIdAndMemberPw(memberId, memberPw);
        if (optional.isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
