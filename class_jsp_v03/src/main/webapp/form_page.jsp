<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	<form action="result.jsp" method="PORT">
	<div class="f1">
		<h2> cm를 인치로 변환</h2>
		<label for="cm">cm 입력 :</label>
		<input type="number" id="cm" name="cm" required="required" step="0.01">
		<button type="submit">변환</button>
		<%@ include file="footer.jsp" %>
		<p>소숫점 둘째 자리까지 입력이 가능합니다.</p>
	</div>
	
	</form>
	
	