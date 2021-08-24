package com.toy.dao;

import java.sql.Connection;
import java.util.List;

import com.toy.dto.ToyBoardDto;
import com.toy.dto.ToyMemberDto;

public interface ToyMemberDao {
        String selectOnesql = "SELECT * FROM TOY_MEMBER WHERE USERID=? and PASSWORD=?";
        String insertSql = "INSERT INTO TOY_MEMBER VALUES(?, ?)";
        // 아이디, 비밀번호 조회
        public ToyMemberDto selectOne(Connection con, String userId, String password);
        // 회원가입
        public boolean insert(Connection con, ToyMemberDto dto);
    } // end class
