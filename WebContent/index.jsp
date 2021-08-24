<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%
    // ���ǰ� ��������
String id = (String) session.getAttribute("Id"); // Object Ÿ���̹Ƿ� �ٿ�ĳ����
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ��Ʈ��Ʈ�� css ��� -->
<link type="text/css" rel="stylesheet"
	href="resource/css/bootstrap.min.css" />
<!--  ��Ʈ��Ʈ�� js ��� -->
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="nav.jsp" flush="false" />
	<%
	    if (id != null) {
	%>
	<hr>
	<div align="center" style=margin-top:20px style="width: 100%">
	<div align="center" class="card text-white bg-primary mb-3" style="max-width: 20rem;">
		<div class="card-header">Toy Board</div>
		<div class="card-body">
			<h4 class="card-title"><%=id%>��,<br><hr> ȯ���մϴ�!</h4>
		</div>
	</div>
	</div>
	

	<%
	    } else {
	%>
	<div align="center">
		<form action="controller.do" method="post">
			<div class="form-group row">
				<input type="hidden" name="command" value="memberLogin">
				<div class="form-group">
					<label for="id" class="form-label mt-4">ID</label> <input
						class="form-control" type="text" id="id" name="f_userId">
				</div>
				<div>
					<label for="pw" class="form-label mt-4">Password</label> <input
						class="form-control" type="password" id="pw" name="f_password">
				</div>
				<input class="btn btn-primary" type="submit" value="Sign In">
				<input class="btn btn-success" type="button" value="Sign Up"
					onclick="location.href='controller.do?command=sign_up'">
			</div>
		</form>
	</div>
	<%
	    }
	%>
</body>
</html>