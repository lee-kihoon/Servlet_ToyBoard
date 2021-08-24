<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>게시글 수정</h1>
    </div>
    <hr>
    <form action="controller.do" method="post">
    <input type="hidden" name="command" value="boardUpdate">
    <input type="hidden" name="no" value="${dto.no }">
    <table class="table table-hover" border="1">
        <tr class="table-primary">
            <th>ID</th>
            <td>${dto.userId } </td>
        </tr>
        <tr class="table-primary">
            <th>TITLE</th>
            <td><input type="text" name="f_title" value="${dto.title }"></td>
        </tr>
        <tr class="table-primary">
            <th>CONTENTS</th>
            <td><textarea rows="10" cols="60" name="f_contents" value="${dto.contents }"></textarea></td>
        </tr>
        <tr class="table-info">
            <td colspan="2" align=center>
                <input class="btn btn-primary" type="submit" value="수정">
                <input class="btn btn-danger" type="button" value="취소" onclick="location.href='controller.do?command=main'">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>