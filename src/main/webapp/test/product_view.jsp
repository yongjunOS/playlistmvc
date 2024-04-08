<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 출력</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<%--EL로 웹 브라우저 정보를 출력한다.--%>
		웹 브라우저 정보 : ${browser}
	</div>
	<div class="container p-3 my-3 border">
		<%--escapeXml 속성값을 false로 설정하여 HTML 태그를 지원하고 상품 코드를 출력한다.--%>
		<c:out value="<b>상품 코드 : ${code}</b>" escapeXml="false" />
	</div>
	<div class="container p-3 my-3 border">
		<%--EL로 상품명을 출력한다.--%>
		상품명 : ${name}
	</div>
	<div class="container p-3 my-3 border">
		<%--EL로 가격을 출력한다.--%>
		가격 : ${price} 원
	</div>
	<div class="container p-3 my-3 border">
		<%--기본값을 설정하여 설정한 파라미터가 없으면 기본값을 출력시킨다.--%>
		<c:out value="${str}" default="기본 데이터가 없습니다." />
	</div>
	<div class="container p-3 my-3 border">
		<%--기본값을 설정하여 설정한 파라미터가 없으면 기본값을 출력시킨다.--%>
		<c:out value="${name}" default="기본 데이터가 없습니다." />
	</div>
</body>
</html>