<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다.</title>
</head>
<body>
	<%
	// http://localhost:8080/jsp/welcome.jsp
	//스크립트릿 <% %   >// 
	// 세션 객체를 사용하여 사용자 정보 여부를 확인하자.
	String username = (String) session.getAttribute("username");
	if (username == null || username.trim().isEmpty()) {
		// 폼 데이터 있는지 없는지 확인 코드
		session.setAttribute("username", "홍길동");
		session.setAttribute("visitCount", 1);
	} else {
		Integer visitCount = (Integer)session.getAttribute("visitCount");
		
		if (visitCount == null) {
			visitCount = 1;
		} else {
			visitCount++;
		}
		application.setAttribute("visitCount", visitCount);
	}

	Date now = new Date();
	%>

	<h2>
		환영 합니다,
		<%=username%>
		님
	</h2>
	<p>
		방문 횟수:
		<%=session.getAttribute("visitCount")%>
	</p>
</body>
</html>