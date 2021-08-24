<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>게시판 목록</h1>
	</div>
	<hr>
	<table class="table table-hover" border="1">
<%-- 		<col width="50px"> --%>
<%-- 		<col width="100px"> --%>
<%-- 		<col width="200px"> --%>
<%-- 		<col width="100px"> --%>
<%-- 		<col width="50px"> --%>
<%-- 		<col width="50px"> --%>
		<tr class="table-primary">
			<th>No</th>
			<th>ID</th>
			<th>Title</th>
			<th>Date</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="dto" items="${ list }">

			<tr class="table-secondary">
				<td>${ dto.no }</td>
				<td>${ dto.userId }</td>
				<td><a href="controller.do?command=one&no=${dto.no}">${dto.title }</a></td>
				<td>${ dto.board_Date }</td>
                <td><a href="controller.do?command=update&no=${dto.no }">수정</a></td>
				<td><a href="controller.do?command=delete&no=${dto.no }">삭제</a></td>
			</tr>
		</c:forEach>
		<tr class="table-info">
		  <td colspan="6">
		      <input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='controller.do?command=insert'">
		  </td>
		</tr>
	</table>
</body>
</html>