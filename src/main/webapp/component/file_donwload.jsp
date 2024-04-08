<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
<%--포워드로 전송할 경우 스타일시트와 자바스크립트를 지원하기 위해 경로를 현재 작업 디렉터리로 변경한다.--%>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border">파일이 업로드되었습니다. 다운로드 페이지입니다.
	</div>
	<div class="container p-3 my-3 border">이름 : ${name}</div>
	<div class="container p-3 my-3 border">제목 : ${subject}</div>
	<div class="container p-3 my-3 border">
		파일 다운로드 : <a href='./FileDownload?file_name=${file_name}'>
			${origfilename} </a>
	</div>
</body>
</html>