<%@page import="org.w3c.dom.Attr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>



<%
// 주소 설계 - http://localhost:8080/jsp/example.jsp
// 초기화 단계 ( jspInit 역할 )
if (application.getAttribute("initialized") == null) {
	application.setAttribute("initialized", true);
	application.setAttribute("initializedTime", new Date());
	out.println("JSP가 초기화 되었습니다. <br>");
}

out.println("요청이 완료 되었습니다. <br>");
out.println("현재 시간 : " + new Date() + " <br>");

// 세션이라는 전역 메모리지에 데이터를 저장하고 확인해 보자.
String message = (String) session.getAttribute("message");
if (message != null) {
	out.println("세션 메세지 : " + message);
} else {
	out.println("저장된 세션 메세지가 없습니다.");
}

// 세션이라는 메모리에 key와 value를 할당해 보자.
session.setAttribute("message", "세션에 저장한 메세지A");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSP 라이프 사이클 확인</h1>
	<p>이 페이지의 학습 목적은 JSP 동작 방식에 대한 이해와 라이프 사이클 입니다.</p>
	
</body>
</html>


<%
// 소멸 단계 확인 (jspDestroy)
if (application.getAttribute("initialized") != null) {
	application.removeAttribute("initialized");
	application.removeAttribute("initializedTime");
	out.println("JSP 객체가(서블릿 객체가) 소멸되었습니다.");
}
%>
