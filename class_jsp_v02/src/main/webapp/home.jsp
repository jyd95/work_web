<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
<%@ page import="java.util.Date" %>
<!-- 경로 설정시 상위 폴더에 있을때? ../~~(상위 폴더로 이동) -->

<h1>JSP 지시자 예제</h1>
<p> 현재 시간 <%= new Date()%>  </p>
<%@ include file="about.jsp" %>
<%@ include file="contact.jsp" %>



<%@ include file="footer.jsp" %>
