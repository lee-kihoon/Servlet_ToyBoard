package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCon {
    public static Connection getConnection() {
        try  {
            // 드라이버 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } // end try-catch
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "scott";
        String pw = "tiger";
        
        Connection con = null;
        try {
            // 계정 연결
            con = DriverManager.getConnection(url, id, pw);
        } catch (SQLException e) {
            e.printStackTrace();
        } // end try-catch
        return con;
    } // end getConnection()
    
    public static boolean isConnection(Connection con) {
        boolean valid = true;
        
        try {
            if(con == null || con.isClosed()) {
                valid = false;
            } // end if
        } catch (SQLException e) {
            valid = true;
            e.printStackTrace();
        } // end try-catch
        return valid;
    } // end isConnection()
    
    public static void close(Connection con) {
         if (isConnection(con)) {
             try {
                 con.close();
             } catch (SQLException e){
                 e.printStackTrace();
             }
         } //end if
    } // end close()
    
    //stmt가 null아닐때 close
    public static void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // end try-catch
        } // end if
    } // end close
 
    //연결 상태라면 commit
    public static void commit(Connection con) {
        if(isConnection(con)) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } // end try-catch
        } // end if
    } // end commit()
    
    //연결 상태라면 rollback
    public static void rollback(Connection con) {
        if(isConnection(con)) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } // end try-catch
        } // end if
    } // end rollback()
    
} // end class
