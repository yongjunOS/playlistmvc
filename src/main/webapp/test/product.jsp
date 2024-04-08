<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 저장</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<%--파라미터에 값을 저장하고 영역 범위를 request로 설정한다.--%>
		<c:set var="code" value="80012" scope="request" />
		<%--파라미터에 값을 저장하고 영역 범위를 request로 설정한다.--%>
		<c:set var="name" value="스마트폰" scope="request" />
		<%--파라미터에 값을 저장하고 영역 범위를 request로 설정한다.--%>
		<c:set var="price" value="15000" scope="request" />
		<%--값을 배열 방식으로 접근하여 파라미터에 저장하고 영역 범위를 request로 설정한다.--%>
		<c:set var="browser" value="${header['User-Agent']}" scope="request" />
		<%--포워드 방식으로 파라미터를 전송한다.--%>
		<jsp:forward page="./product_view.jsp" />
	</div>
</body>
</html>