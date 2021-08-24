<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("Id"); // Object 타입이므로 다운캐스팅
%>
<!-- 부트스트랩 css 사용 -->
<link rel="stylesheet" href="/resource/css/bootstrap.css">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">ToyBoard</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
        
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link active"
					href="index.jsp">Home <span class="visually-hidden">(current)</span>
				</a></li>

				
				<% if (id != null) { %>
				<li class="nav-item"><a class="nav-link"
                    href="controller.do?command=main">BOARD</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="controller.do?command=logout">Logout <span class="visually-hidden">(current)</span>
				</a></li>
				<% } else { %>
				    <li class="nav-item"><a class="nav-link active"
                    href="index.jsp">Login <span class="visually-hidden">(current)</span>
                </a></li>
                
				<%} %>
			</ul>
    
		</div>
	</div>
</nav>