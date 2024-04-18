package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.one2one.One2one;
import com.study.Ex14RealDB.domain.one2one.One2oneRepository;
import com.study.Ex14RealDB.dto.One2oneSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class One2oneService {
    final private One2oneRepository one2oneRepository;


    @Transactional
    public Long save(One2oneSaveRequestDto dto) {
        One2one one = one2oneRepository.save(dto.toEntity());
        return one.getOne2oneIdx();
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long newIdx) {
        return one2oneRepository.existsById(newIdx);
    }
}
