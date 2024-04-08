<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<%--특수기호를 인식하고 처리한다.--%>
		escapeXml 속성 :
		<c:out value='<font color="blue"> 파랑 </font>' escapeXml="false" />
	</div>
	<div class="container p-3 my-3 border">
		<%--속성값을 세션에 저장한다.--%>
		<c:set var="name" value="홍길동" scope="session" />
		<%--속성값을 호출하고 출력한다.--%>
		이름 :
		<c:out value="${name}" />
	</div>
</body>
</html>