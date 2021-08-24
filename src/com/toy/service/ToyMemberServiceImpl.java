package com.toy.service;

import java.sql.Connection;

import com.jdbc.JdbcCon;
import com.toy.dao.ToyMemberDao;
import com.toy.dao.ToyMemberDaoImpl;
import com.toy.dto.ToyMemberDto;

public class ToyMemberServiceImpl implements ToyMemberService {
    private ToyMemberDao dao = new ToyMemberDaoImpl();

    @Override
    public ToyMemberDto selectOne(String userId, String password) {
        Connection con = JdbcCon.getConnection();
        ToyMemberDto dto = dao.selectOne(con, userId, password);
        JdbcCon.close(con);
        return dto;
    }

    @Override
    public boolean insert(ToyMemberDto dto) {
        Connection con = JdbcCon.getConnection();
        boolean res = dao.insert(con, dto);
        if (res) {
            JdbcCon.commit(con);
        }
        JdbcCon.close(con);

        return res;
    }
}
