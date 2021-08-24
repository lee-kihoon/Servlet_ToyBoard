<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
// 세션값 가져오기
    String id = (String) session.getAttribute("Id"); // Object 타입이므로 다운캐스팅
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css" />
<!--  부트스트랩 js 사용 -->
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</head>

<body>
    <jsp:include page="nav.jsp" flush="false"/>
    <hr>
    <div align="center">
    <h1>글작성</h1>
    
    </div>
    <hr>
    
    <form action="controller.do" method="post">
    <input type="hidden" name="command" value="boardInsert">
    <table border="1" class="table table-hover">
        <tr class="table-primary">
            <th>ID</th>
            <td><input type="text" name="f_userId" value="<%= id %>" readonly></td>
        </tr>
        <tr class="table-primary">
            <th>TITLE</th>
            <td><input type="text" name="f_title"></td>
        </tr>
        <tr class="table-primary">
            <th>CONTENTS</th>
            <td><textarea rows="10" cols="60" name="f_contents"></textarea></td>
        </tr>
        <tr class="table-info">
            <td colspan="2" align="center">
                <input class="btn btn-primary" type="submit" value="입력">
                <input class="btn btn-danger" type="button" value="취소" onclick="location.href='controller.do?command=main'">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>