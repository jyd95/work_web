<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		height: 100vh;
		background-color: #760C0C;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
	}

	.item{
		display: flex;
		justify-content: space-evenly;
		height: calc(33.333%);
		font-size: 150px;
		
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
<%--   
	http://localhost:8080/flex/index.jsp
	http://localhost:8080/flex (welcome file 에 설정되어 있으므로 이렇게도 가능)
--%>
	<div class="item">
		<p>item1</p>
	</div>
	<div class="item">
		<p>item2</p>
	</div>
	<div class="item">
		<p>item3</p>
	</div>
	
	
</body>
</html>