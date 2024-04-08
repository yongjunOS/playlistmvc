<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드 액션</title>
</head>
<body>
	<%--파라미터를 동적 경로로 호출하고 제어권 영구적으로 넘기며 <jsp:param> 태그에 주석문을 설정하면 오류가 발생한다.--%>
	<jsp:forward page="${param.page}">
		<jsp:param name="tel" value="010-9740-4065" />
	</jsp:forward>
</body>
</html>