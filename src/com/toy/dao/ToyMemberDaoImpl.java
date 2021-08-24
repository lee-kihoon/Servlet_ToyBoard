package com.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.JdbcCon;
import com.toy.dto.ToyBoardDto;
import com.toy.dto.ToyMemberDto;

public class ToyMemberDaoImpl implements ToyMemberDao {
    @Override
    public ToyMemberDto selectOne(Connection con, String userId, String password) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ToyMemberDto res = null;
        
        try {
            pstm = con.prepareStatement(selectOnesql);
            pstm.setString(1, userId);
            pstm.setString(2, password);
            
            rs = pstm.executeQuery();
            
            while(rs.next()) {
                res = new ToyMemberDto(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcCon.close(rs);
            JdbcCon.close(pstm);
        }
        
        return res;
    }
    
    @Override
    public boolean insert(Connection con, ToyMemberDto dto) {
        PreparedStatement pstm = null;
        int res = 0;
        
        try {
            pstm = con.prepareStatement(insertSql);
            pstm.setString(1, dto.getUserId() );
            pstm.setString(2, dto.getPassword() );
            
            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcCon.close(pstm);
        }
        
        return (res>0)?true:false;
    }
}
