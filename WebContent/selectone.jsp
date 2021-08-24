<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
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
    <h1>게시글</h1>
    </div>
    <hr>
    <div>
    <table class="table table-hover" border="1">
<!--         <col width="50px"> -->
<!--         <col width="100px"> -->
<!--         <col width="200px"> -->
<!--         <col width="100px"> -->
<!--         <col width="50px"> -->
<!--         <col width="50px"> -->
        <tr class="table-primary">
            <th>ID</th>
            <td>${dto.userId }</td>
        </tr>
        <tr class="table-primary">
            <th>TITLE</th>
            <td>${dto.title }</td>
        </tr>
        <tr class="table-primary">
            <th>CONTENTS</th>
            <td><textarea  rows="10" cols="60" readonly>${dto.contents }</textarea></td>
        </tr>
        <tr class="table-info">
            <td colspan="2" align="center">
                <input class="btn btn-primary" type="button" value="수정" onclick="location.href='controller.do?command=update&no=${dto.no}'">
                <input class="btn btn-danger" type="button" value="삭제" onclick="">
                <input class="btn btn-light" type="button" value="목록" onclick="location.href='controller.do?command=main'">
            </td>
        </tr>
        
    </table>
    </div>
</body>
</html>