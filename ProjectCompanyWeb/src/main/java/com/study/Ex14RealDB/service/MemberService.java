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


    // 전체 검색
    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberId(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberId(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberIdLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberIdLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberIdLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberIdLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberIdDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberIdDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberIdDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberIdDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByMemberIdDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByMemberIdDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDateLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDateLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDateLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDateLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDate(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDate(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDateDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDateDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDateDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDateDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByKeywordOrderByJoinDateDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByKeywordOrderByJoinDateDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    // 아이디 검색
    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberId(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberId(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberIdLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberIdLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberIdLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberIdLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberIdDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberIdDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberIdDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberIdDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByMemberIdDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByMemberIdDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDateLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDateLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDateLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDateLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDate(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDate(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDateDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDateDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDateDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDateDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberIdOrderByJoinDateDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberIdOrderByJoinDateDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    // 이름 검색

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberId(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberId(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberIdLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberIdLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberIdLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberIdLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberIdDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberIdDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberIdDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberIdDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByMemberIdDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByMemberIdDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDateLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDateLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDateLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDateLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDate(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDate(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDateDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDateDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDateDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDateDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberNameOrderByJoinDateDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberNameOrderByJoinDateDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    // 이메일 검색
    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberId(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberId(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberIdLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberIdLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberIdLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberIdLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberIdDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberIdDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberIdDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberIdDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByMemberIdDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByMemberIdDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDateLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDateLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDateLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDateLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDate(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDate(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDateDescLimit5(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDateDescLimit5(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDateDescLimit10(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDateDescLimit10(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MemberResponseDto> searchByMemberEmailOrderByJoinDateDesc(String searchKeyword) {
        List<Member> list = memberRepository.searchByMemberEmailOrderByJoinDateDesc(searchKeyword);
        return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

}
