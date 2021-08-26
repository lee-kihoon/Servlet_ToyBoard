package com.toy.service;

import java.util.List;

import com.toy.dto.ToyBoardDto;

public interface ToyBoardService {
 // 게시글 전체 출력
    public List<ToyBoardDto> selectAll();
    // 게시글 하나 출력
    public ToyBoardDto selectOne(int no);
    // 글쓰기 
    public boolean insert(ToyBoardDto dto);
    // 글수정
    public boolean update(ToyBoardDto dto);
    // 글삭제
    public boolean delete(int no);
}
