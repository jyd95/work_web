<%@page import="com.tenco.mdels.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.yy{
	<%if(true){
		%>
	backgroundcolor:red;
		
	<%}%>
}
</style>
</head>
<body>
	
	<h1>USERLIST PAGE</h1>
	<%
		List<User> userList = (List<User>)request.getAttribute("userList");
	%>
	
	<tabla border="1">
		<tr>
			<th id="nn">ID</th>
			<th class="yy">이름</th>
			<th>이메일</th>
		</tr>
		<%
			for(User user : userList){%>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getPassword()%></td>
				
			<%}%>
			
		%>
		
	
	</tabla>
	
	
	
</body>
</html>