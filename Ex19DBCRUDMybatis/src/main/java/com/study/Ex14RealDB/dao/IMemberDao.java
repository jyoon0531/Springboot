package com.study.Ex14RealDB.dao;

import com.study.Ex14RealDB.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

// @Mapper : 인터페이스 DAO와 Mybatis XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    // select * from member
    public List<MemberDto> list();

    // count(*)
    public int count();

    // insert into member values ()
    public int insert(MemberDto dto);

    // select * from member where id = ?
    public Optional<MemberDto> findById(int id);

    // update
    public int update(MemberDto dto);

    // delete
    public int delete(MemberDto dto);



}
