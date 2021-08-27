package com.toy.dto;

import java.sql.Date;

public class ToyBoardDto {
    // 필드
    private int no;
    private String userId;
    private String title;
    private String contents;
    private Date board_Date;
    // end 필드
     
    // 생성자
    public ToyBoardDto() {
        super();
    }
    
    public ToyBoardDto(String userId, String title, String contents) {
        super();
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
    public ToyBoardDto(int no, String title, String contents) {
        super();
        this.no = no;
        this.title = title;
        this.contents = contents;
    }
    
    public ToyBoardDto(int no, String userId, String title, String contents, Date board_Date) {
        super();
        this.no = no;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.board_Date = board_Date;
        
    }
    // end 생성자
    
    // getter & setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getBoard_Date() {
        return board_Date;
    }

    public void setBoard_Date(Date board_Date) {
        this.board_Date = board_Date;
    }
    // end getter & setter
} // end class
