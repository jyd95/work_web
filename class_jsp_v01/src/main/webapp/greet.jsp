<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 위 코드는 JSP 페이지의 설정을 정의하는 지시자 -->    
<!-- 주석 단축키 ctrl + shift + / -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인사말을 완성하였습니다.</h1>
	
	<%
		// 자바 실행 코드
		// request 객체에서 값 추출하기
		
		String name = request.getParameter("name");
		if(name == null || name.trim().isEmpty()){
			out.println("<p>잘못된 사용자 이름입니다. 다시 입력하세요</p>");
		}else {
			out.println("<p>반갑습니다 " + name + " 사용자님 JSP 페이지에 오신것을 환영합니다.</p>");
		}
		
	%>
	
	<!-- 다시 이전 페이지로( 특정 페이지로 이동 ) -->
	<a href="greet_form_page.html">back</a>
</body>
</html>