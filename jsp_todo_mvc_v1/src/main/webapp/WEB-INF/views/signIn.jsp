<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        width: 300px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .container h2 {
        margin-bottom: 20px;
    }
    .container form {
        width: 100%;
        display: flex;
        flex-direction: column;
    }
    .container form label {
        margin-bottom: 5px;
    }
    .container form input {
        margin-bottom: 15px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .container form button {
        padding: 10px;
        background-color: #007BFF;
        border: none;
        border-radius: 4px;
        color: white;
        cursor: pointer;
    }
    .container form button:hover {
        background-color: #0056b3;
    }
    .message {
        color: blue;
        margin-bottom: 15px;
    }
</style>
</head>
<body>
<div class="container">
	<h2>로그인</h2>
	<!-- 회원 가입 성공 메세지 출력 -->
	<%
		//String errorMessage = (String)request.getAttribute("message"); - 동작 안함
		String success = (String)request.getParameter("message"); // 동작 함
		if(success != null){
	%>
		<p style="color:blue"> <%=success%></p>
	
	<%}%>
	<!-- 절대 경로로 주소 설계 해보기 -->
	<form action="/mvc/user/signIn" method="POST">
		<label for="username">사용자 이름:</label>
		<input type="text" id="username" name="username" value="홍길동"><br>
		<label for="password">비밀번호:</label>
		<input type="password" id="password"" name="password"" value="asd123"><br>
		
		<button type="submit">로그인</button>
	</form>
	</div>
</body>
</html>