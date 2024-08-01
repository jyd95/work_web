<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>


	<h2>게시글 목록</h2>
	<%
		ResultSet rs = (ResultSet)request.getAttribute("resultSet");
		if(rs != null){
	%>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th></th>
			</tr>
			<%
				while(rs.next()){
					
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><a href="view-post?boardId=<%=rs.getInt("id")%>"><%=rs.getString("title")%></a></td>
				<td><%=rs.getString("content")%></td>
				<td><%=rs.getString("created_at")%></td>
				<td>
					<form action="delete-post" method="GET">
						<input type="hidden" name="boardId" value="<%=rs.getInt("id")%>">
						<button type="submit">삭제</button>	
					</form>
				</td>
			</tr>
			<%}%>
		</table>
	<%}else{%>
		<p>현재 작성된 게시글이 없습니다.</p>
	<%}%>
</body>
</html>