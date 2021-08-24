package com.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JdbcCon;
import com.toy.dto.ToyBoardDto;

public class ToyBoardDaoImpl implements ToyBoardDao {
    @Override
    public List<ToyBoardDto> selectAll(Connection con) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ToyBoardDto> res = new ArrayList<ToyBoardDto>();

        try {
            pstm = con.prepareStatement(selectAllsql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ToyBoardDto tmp = new ToyBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5));
                res.add(tmp);
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
    public ToyBoardDto selectOne(Connection con, int no) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ToyBoardDto res = null;

        try {
            pstm = con.prepareStatement(selectOnesql);
            pstm.setInt(1, no);

            rs = pstm.executeQuery();

            while (rs.next()) {
                res = new ToyBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
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
    public boolean insert(Connection con, ToyBoardDto dto) {
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(insertSql);
            pstm.setString(1, dto.getUserId());
            pstm.setString(2, dto.getTitle());
            pstm.setString(3, dto.getContents());

            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcCon.close(pstm);
        }

        return (res > 0) ? true : false;
    }

    @Override
    public boolean update(Connection con, ToyBoardDto dto) {
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(updateSql);
            pstm.setString(1, dto.getTitle());
            pstm.setString(2, dto.getContents());
            pstm.setInt(3, dto.getNo());

            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcCon.close(pstm);
        }
        return (res > 0) ? true : false;

    }

    @Override
    public boolean delete(Connection con, int no) {
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(deleteSql);
            pstm.setInt(1, no);

            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcCon.close(pstm);
        }
        return (res > 0) ? true : false;
    }

} // end class
