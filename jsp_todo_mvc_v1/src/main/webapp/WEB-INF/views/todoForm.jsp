<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 할일 추가</title>
</head>
<body>
	<h1>Todo 페이지</h1>
	<%-- http://localhost:8080/mvc/todo/add --%>
	<form action="add" method="POST">
	<label for="title">제목: </label>
	<input type="text" id="title" name="title" value="릅탄돌리기"><br> <br>
	
	<label for="description">설명: </label>
	<textarea rows="30" cols="50" id="description" name="description">
		샷클락 3초 남았을때 탄돌리기
	</textarea><br><br>
	
	<label for="dueDate">마감기한: </label>
	<input type="date" id="dueDate" name="dueDate" value="2024-07-11"><br><br>
	
	<label for="completed">완료 여부: </label>
	<input type="checkbox" id="completed" name="completed"><br><br>
	<button type="submit">추가</button>
	
	</form>
	<br><br>
	<a href="list">Todo 목록으로 돌아가기</a>
	
</body>
</html>