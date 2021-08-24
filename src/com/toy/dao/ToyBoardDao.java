package com.toy.dao;

import java.sql.Connection;
import java.util.List;

import com.toy.dto.ToyBoardDto;

public interface ToyBoardDao {
    String selectAllsql = "SELECT * FROM TOY_BOARD ORDER BY NO DESC";
    String selectOnesql = "SELECT * FROM TOY_BOARD WHERE NO=? ORDER BY NO DESC";
    String insertSql = "INSERT INTO TOY_BOARD VALUES(TOY_BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
    String updateSql = "UPDATE TOY_BOARD SET TITLE=?, CONTENTS=? WHERE NO=?";
    String deleteSql = "DELETE FROM TOY_BOARD WHERE NO=?";
    // 게시글 전체 출력
    public List<ToyBoardDto> selectAll(Connection con);
    // 게시글 하나 출력
    public ToyBoardDto selectOne(Connection con, int no);
    // 글쓰기
    public boolean insert(Connection con, ToyBoardDto dto);
    // 글수정
    public boolean update(Connection con, ToyBoardDto dto);
    // 글삭제
    public boolean delete(Connection con, int no);
} // end class
