<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--객체를 호출하고 파라미터에 저장하여 반복한다.--%>
<c:forEach var="arrayList" items="${arrayList}">
	

</c:forEach>

</head>
<body>
	<script type="text/javascript">
		//경고창으로 재생목록 번호를 확인할 수 있도록 설정한다.
		alert("재생목록 만들기 완료");
		location.href = "./PlayListSelect.pl"
	</script>
</body>
</html>