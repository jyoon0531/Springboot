package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.member.Member;
import com.study.Ex14RealDB.domain.member.MemberRepository;
import com.study.Ex14RealDB.dto.MemberResponseDto;
import com.study.Ex14RealDB.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public MemberResponseDto findByMemberPwAndMemberId(String memberPw, String memberId) {
        Optional<Member> optional = memberRepository.findByMemberPwAndMemberId(memberPw, memberId);
        if (optional.isPresent()) {
            return MemberResponseDto.builder()
                    .memberId(optional.get().getMemberId())
                    .build();
        } else {
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

    @Transactional(readOnly = true)
    public String findByMemberNameAndMemberEmail(String memberName, String memberEmail) {
        Optional<Member> optional = memberRepository.findByMemberNameAndMemberEmail(memberName, memberEmail);

        if (optional.isPresent()) {
            return optional.get().getMemberId();
        } else {
            return "회원정보가 없습니다.";
        }
    }

    @Transactional(readOnly = true)
    public String findByMemberNameAndMemberEmailAndMemberId(String memberName, String memberEmail, String memberId) {
        Optional<Member> optional = memberRepository.findByMemberNameAndMemberEmailAndMemberId(memberName, memberEmail, memberId);

        if (optional.isPresent()) {
            return optional.get().getMemberPw();
        } else {
            return "회원정보가 없습니다.";
        }
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> list = memberRepository.findAll();
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public long count() {
        return memberRepository.count();
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberId(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberId(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberName(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberName(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmail(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmail(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeyword(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeyword(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> sortOrderByMemberId() {
        Sort sort = Sort.by(Sort.Direction.ASC, "memberId");
        List<Member> list = memberRepository.findAll(sort);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> sortOrderByMemberIdDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "memberId");
        List<Member> list = memberRepository.findAll(sort);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> sortOrderByMemberJoinDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "memberJoinDate");
        List<Member> list = memberRepository.findAll(sort);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> sortOrderByMemberJoinDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "memberJoinDate");
        List<Member> list = memberRepository.findAll(sort);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findLimit5() {
        List<Member> list = memberRepository.findLimit5();
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findLimit10() {
        List<Member> list = memberRepository.findLimit10();
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }
}
