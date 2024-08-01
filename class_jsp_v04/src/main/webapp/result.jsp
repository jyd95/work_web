<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>폼 제출 결과 확인 페이지</h1>
	
	<%
		String username = request.getParameter("username");
		String[] hobbies = request.getParameterValues("hobbies");
		String faColor = request.getParameter("favoritColor");	
	%>
	
	<p>Username : <%=username %> </p>
	
	
	<%
		if(hobbies != null){
	%>		
		<p>Hobbies : </p>
		<ul>
			<%for(String hobby: hobbies){%>
			<li><%= hobby %></li>
			<%} %>
		</ul>
	<%}else{%>
		<!-- HTML 영역 -->
		<p>선택된 취미가 없습니다.</p>
	<%
		}
	%>
		
	<p> color : <%= faColor != null ? faColor : "선택한 색상이 없네요." %>	
		
</body>
</html>