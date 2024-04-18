package com.study.Ex14RealDB.domain.qna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {
    @Query(value = "SELECT * FROM company_qna q WHERE q.qna_title LIKE %:keyword%", nativeQuery = true)
    List<Qna> findByQnaTitle(String keyword);

    @Query(value = "SELECT * FROM company_qna q WHERE q.qna_content LIKE %:keyword%", nativeQuery = true)
    List<Qna> findByQnaContent(String keyword);

    @Query(value = "SELECT * FROM company_qna q WHERE q.qna_name LIKE %:keyword%", nativeQuery = true)
    List<Qna> findByQnaName(String keyword);
}
