<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 무효화 하기</title>
</head>
<body>

	<%
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a == 1){
		out.println("세션의 현재 속성값들 : "+ session.getId()); 
		session.removeAttribute("username");
		session.removeAttribute("age");
		out.println("세션 속성 파괴");		
		out.println("세션의 현재 속성값들 : " + session.getId()); 
	%>
	<a href="getSession.jsp">무효화된 세션 확인해 보기</a> 
	<%
	}
	else if(a==2){
		out.println("세션의 현재 속성값들 : " + session.getId());
		out.println("전체 세션 무력화 session.invalidate();");		
		session.invalidate();
		out.println("세션의 현재 속성값들 : " + session.getId()); 
		%><a href="getSession.jsp">무효화된 세션 확인해 보기</a><%
	}else{
		out.println("잘못된 입력입니다.");
	}
	sc.close();
	%>
</body>
</html>