<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<col width="50px">
		<col width="50px">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Title</th>
			<th>Date</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="dto" items="${ list }">

			<tr>
				<td>${dto.no }</td>
				<td>${dto.userId }</td>
				<td><a href="controller.do?command=one&no=${dto.no}">${dto.title }</a></td>
				<td>${dto.board_Date }</td>
				<td><a href="controller.do?command=update&no=${dto.no }">수정</a></td>
				<td><a href="controller.do?command=delete&no=${dto.no }">삭제</a></td>
			</tr>
		</c:forEach>
		<tr>
		  <td colspan="6">
		      <input type="button" value="글쓰기" onclick="location.href='controller.do?command=insert'">
		  </td>
		</tr>
	</table>
</body>
</html>