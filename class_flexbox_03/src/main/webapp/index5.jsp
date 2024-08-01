
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	
}

.out {
	width: 500px;
	height: 500px;
	background-color: #ddffff;
	display: flex;
	justify-content: center;
	border: 1px solid orange;
	border-radius: 15px;
	align-items: center;
}

.item {
	display: flex;
	border: 1px solid #fff6dd;
	border-radius: 15px;
	width: 300px;
	height: 300px;
	background-color: #fff6dd;
	font-size: 30px;
	color: #ff7f50;
	justify-content: center;
	align-items: center;
	
}
/* 	.order-1{
		justify-content: flex-start;
		align-items: center;
	}
	.order-2{
		justify-content: center;
		align-items: center;
	}
	.order-1{
		justify-content: flex-start;
		align-items: flex-end;
	} */
</style>
</head>
<body>
	<div class="out">
		<div class="item">item child</div>
	</div>
</body>
</html>
