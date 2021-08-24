<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>글작성</h1>
    <form action="controller.do" method="post">
    <input type="hidden" name="command" value="boardInsert">
    <table border="1">
        <tr>
            <th>ID</th>
            <td><input type="text" name="f_userId"></td>
        </tr>
        <tr>
            <th>TITLE</th>
            <td><input type="text" name="f_title"></td>
        </tr>
        <tr>
            <th>CONTENTS</th>
            <td><textarea rows="10" cols="60" name="f_contents"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="입력">
                <input type="button" value="취소" onclick="location.href='controller.do?command=main'">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>