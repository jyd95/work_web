
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.back{
	display: flex;
	flex-direction: column;
	height: 100vh;
	justify-content: center;
	align-content: center;
}


.item {
	border: 1px dotted green;
	width: calc(33.333%);
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
	<div class ="back">
		<div class="tbox">
			<div class="item">c-item1</div>
			<div class="item">c-item2</div>
			<div class="item">c-item3</div>
		</div>
		<div class="mbox">
			<div class="item">c-item4</div>
			<div class="item">c-item5</div>
			<div class="item">c-item6</div>
		</div>
		<div class="bbox">
			<div class="item">c-item7</div>
			<div class="item">c-item8</div>
			<div class="item">c-item9</div>
		</div>
	</div>
</body>
</html>
