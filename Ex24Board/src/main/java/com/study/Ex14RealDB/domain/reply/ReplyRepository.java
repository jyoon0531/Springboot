package com.study.Ex14RealDB.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 기본함수 : findAll, existsById, save(UPDATE, INSERT), delete

    // 쿼리메소드
    List<Reply> findAllByReplyBoardIdx(Long replyBoardIdx);     // 게시글 인덱스로 댓글 목록 찾기

}
