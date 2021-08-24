<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css 사용 -->
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css" />
<!--  부트스트랩 js 사용 -->
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</head>
<body>
    <jsp:include page="nav.jsp" flush="false"/>
    <form action="controller.do" method="post">
    <div class="form-group row" align="center">
        <input type="hidden" name="command" value="memberInsert">
        <div class="form-group">
        <label for="id" class="form-label mt-4">Email address</label>
        <input class="form-control" type="text" id="id" name="f_userId">
        </div>
        <div class="form-group">
        <label for="pw" class="form-label mt-4">Email address</label>
        <input class="form-control" type="password" id="pw" name="f_password">
        </div>
        <input class="btn btn-primary" type="submit" value="회원가입">
        <input class="btn btn-success" type="button" value="취소" onclick="location.href='controller.do?command=main'">
    </div>
    </form>
</body>
</html>