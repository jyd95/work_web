<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<form>
	<h1>변환 결과</h1>
	<%
		Double cm = Double.parseDouble(request.getParameter("cm"));
		DecimalFormat df = new DecimalFormat("###,###.###");
		// 폼에서 데이터 추출
		Double convertCm = cm / 2.54; 
		String formattedCmToInch = df.format(convertCm);
		out.println("인치 변환 결과 : " + formattedCmToInch + " 인치");
	%>
	<a href="form_page.jsp">돌아가기</a>
	</form>
</body>
</html>