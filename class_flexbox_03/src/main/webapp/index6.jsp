
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
}

.tbox {
	background-color: #b22222;
	display: flex;
	height: calc(33.333%);
}
.mbox {
	background-color: #f08080;
	display: flex;
	height: calc(33.333%);
}
.bbox {
	background-color: #f0f8ff;
	display: flex;
	height: calc(33.333%);
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
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
		</div>
		<div class="mbox">
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
		</div>
		<div class="bbox">
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
		</div>
	</div>
</body>
</html>
