<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보</title>
<%--포워드로 전송할 경우 스타일시트와 자바스크립트를 지원하기 위해 경로를 현재 작업 디렉터리로 변경한다.--%>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<%--프로퍼티로 접근하여 출력한다.--%>
		이름 : ${membershipDTO.name}
	</div>
	<div class="container p-3 my-3 border">
		성별 :
		<%--다중 조건을 처리한다.--%>
		<c:choose>
			<%--값이 m일 때 조건을 실행한다.--%>
			<c:when test="${membershipDTO.gender=='m'}"> 남자 </c:when>
			<%--조건이 만족하지 않을 때 실행한다.--%>
			<c:otherwise> 여자 </c:otherwise>
		</c:choose>
	</div>
	<div class="container p-3 my-3 border">
		취미 :
		<c:forEach var="hobby" items="${membershipDTO.hobby}">
			<%--반복하는 파라미터를 호출한다.--%>
${hobby} </c:forEach>

	</div>
</body>
</html>