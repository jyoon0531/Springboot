package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.member.Member;
import com.study.Ex14RealDB.domain.member.MemberRepository;
import com.study.Ex14RealDB.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    final private MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto dto) {
        Member entity = memberRepository.save(dto.toEntity());
        return entity.getMemberIdx();
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long newIdx) {
        boolean isFound = memberRepository.existsById(newIdx);
        return isFound;
    }

    @Transactional(readOnly = true)
    public boolean findByMemberId(String memberId) {
        Optional<Member> optional = memberRepository.findByMemberId(memberId);
        if (optional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = true)
    public Member findByMemberPwAndMemberId(String memberPw, String memberId) {
        Optional<Member> optional = memberRepository.findByMemberPwAndMemberId(memberPw, memberId);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }

    }

    @Transactional(readOnly = true)
    public boolean findByMemberPw(String memberPw) {
        Optional<Member> optional = memberRepository.findByMemberPw(memberPw);
        if (optional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
