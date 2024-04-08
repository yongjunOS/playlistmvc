
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 가져오기</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			// 데이터를 인서트한다.
			$("#insert").load("./load.jsp");
		});
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<button class="btn btn-info">데이터 가져오기</button>
	</div>
	<div class="container p-3 my-3 border">
		<div id="insert">데이터 가져오기 전</div>
	</div>
</body>
</html>
