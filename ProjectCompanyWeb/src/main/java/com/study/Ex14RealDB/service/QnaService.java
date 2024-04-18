package com.study.Ex14RealDB.service;

import com.study.Ex14RealDB.domain.qna.Qna;
import com.study.Ex14RealDB.domain.qna.QnaRepository;
import com.study.Ex14RealDB.dto.QnaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QnaService {
    final private QnaRepository qnaRepository;

    @Transactional(readOnly = true)
    public List<QnaResponseDto> findAll() {
        List<Qna> list = qnaRepository.findAll();
        return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QnaResponseDto> findByQnaTitle(String searchKeyword) {
        List<Qna> list = qnaRepository.findByQnaTitle(searchKeyword);
        return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QnaResponseDto> findByQnaContent(String searchKeyword) {
        List<Qna> list = qnaRepository.findByQnaContent(searchKeyword);
        return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QnaResponseDto> findByQnaName(String searchKeyword) {
        List<Qna> list = qnaRepository.findByQnaName(searchKeyword);
        return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public QnaResponseDto findById(Long qnaIdx) {
        Optional<Qna> entity = qnaRepository.findById(qnaIdx);

        if (entity.isPresent()) {
            return QnaResponseDto.builder()
                    .qnaIdx(entity.get().getQnaIdx())
                    .qnaName(entity.get().getQnaName())
                    .qnaPw(entity.get().getQnaPw())
                    .qnaTitle(entity.get().getQnaTitle())
                    .qnaContent(entity.get().getQnaContent())
                    .qnaDate(entity.get().getQnaDate())
                    .build();
        } else {
            return null;
        }

    }
}
