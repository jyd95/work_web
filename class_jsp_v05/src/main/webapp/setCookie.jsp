<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = "홍길동";
	Cookie userCookie = new Cookie("username", username);
	/* 쿠키는 서버 측에 저장 된다? X , 요청한 클라이언트 브라우저에 저장된다 
		즉 setCookie.jsp 를 요청한 사용자의 response 객체로 데이터 조각을 담아서
		보내 주어야 한다.
	*/
	userCookie.setMaxAge(60 * 60 * 24);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자가 이 페이지 요청시에 서버측에서 쿠키를 생성해서 응답 합니다.</h1>
</body>
</html>