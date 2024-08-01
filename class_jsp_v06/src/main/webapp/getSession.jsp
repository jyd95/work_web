<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션을 읽어보는 페이지</title>
</head>
<body>
	<h2>세션 읽기</h2>
	<%
	// 예외처리 - 삼항연산자, if else , trycatch 사용 가능
	if (session.getAttribute("username") != null) {
		String username = (String) session.getAttribute("username");
		if (session.getAttribute("age") != null) {
			int age = (int) session.getAttribute("age");
			if (username != null) {
		out.println("<p>안녕 " + username + "</p>");
		out.println("<p>나이는 " + age + " 이네요! </p>");
		%>
		<a href="destroySession.jsp">세션 무효화 하러 가기</a>
		<%
			} else {
		out.println("세션 설정이 되지 않았습니다.");
			}
		} else {
	%>
	<a href="setSession.jsp">세션 설정하러 가기</a>
	<%
	}
	} else {
	%>
	<a href="setSession.jsp">세션 설정하러 가기</a>
	<%
	}
	%>
</body>
</html>