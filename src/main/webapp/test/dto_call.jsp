<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty param.name}">
    <p>파라미터 없음</p>
    <form action="#">
        <input type="text" name="name">
        <input type="submit">
    </form>
</c:if>
<c:if test="${!empty param.name}">반갑습니다</c:if>
</body>
</html>
