package com.toy.service;

import java.sql.Connection;
import java.util.List;

import com.jdbc.JdbcCon;
import com.toy.dao.ToyBoardDao;
import com.toy.dao.ToyBoardDaoImpl;
import com.toy.dto.ToyBoardDto;


public class ToyBoardServiceImpl implements ToyBoardService {
    private ToyBoardDao dao = new ToyBoardDaoImpl();
    @Override
    public List<ToyBoardDto> selectAll() {
        Connection con = JdbcCon.getConnection();
        List<ToyBoardDto> res = dao.selectAll(con);
        JdbcCon.close(con);
        return res;
    }
    
    @Override
    public ToyBoardDto selectOne(int no) {
        Connection con = JdbcCon.getConnection();
        ToyBoardDto dto = dao.selectOne(con,  no);
        JdbcCon.close(con);
        return dto;
    }
    
    @Override
    public boolean insert(ToyBoardDto dto) {
        Connection con = JdbcCon.getConnection();
        boolean res = dao.insert(con, dto);
        if(res) {
            JdbcCon.commit(con);
        }
        JdbcCon.close(con);
        
        return res;
    }
    
    @Override
    public boolean update(ToyBoardDto dto) {
        Connection con = JdbcCon.getConnection();
        boolean res = dao.update(con, dto);
        if(res) {
            JdbcCon.commit(con);
        }
        JdbcCon.close(con);
        
        return res;
    }
    
    @Override
    public boolean delete(int no) {
        Connection con = JdbcCon.getConnection();
        boolean res = dao.delete(con, no);
        if(res) {
            JdbcCon.commit(con);
        }
        JdbcCon.close(con);
        return res;
    }
}
