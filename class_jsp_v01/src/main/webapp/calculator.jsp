<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산 결과</h1>
	
	<!-- html 주석. -->
	<%-- JSP 주석 --%>
	<%
		// 폼에서 데이터 추출
		Float num1 = Float.parseFloat(request.getParameter("num1"));
		Float num2 = Float.parseFloat(request.getParameter("num2"));
		String symbol = request.getParameter("symbol");
	
		// 방어적 코드 작성
		if(num1 == null || num2 == null || symbol == null){
			out.println("<p>잘못된 요청입니다 다시 요청해 주세요</p>");
		}else{
		// 계산에 결과를 스트림을 통해 내려주기
			if(symbol.equals("+")){
				float result = num1 + num2;
				out.println("<p>요청하신 계산의 결과는 : " + result + " 입니다.</p>");
			}else if(symbol.equals("-")){
				float result = num1 - num2;
				out.println("<p>요청하신 계산의 결과는 : " + result + " 입니다.</p>");
			}else if(symbol.equals("*")){
				float result = num1 * num2;
				out.println("<p>요청하신 계산의 결과는 : " + result + " 입니다.</p>");
			}else if(symbol.equals("/")){
				float result = num1 / num2;
				out.println("<p>요청하신 계산의 결과는 : " + result + " 입니다.</p>");
			}else {
				out.println("어케함?");
			}
		}
		
	%>
		
	<a href="calculator_form.html">돌아가기</a>
	
</body>
</html>