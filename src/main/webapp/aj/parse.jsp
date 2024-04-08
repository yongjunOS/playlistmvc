<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 객체 반환</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<div class="container p-3 my-3 border" id="access"></div>
	<script>
		// JSON 형식의 문자열 객체를 선언한다.
		data = '{"name": "홍길동", "age": 33, "city": "서울"}'; // 문자열 객체를 JSON 객체로 변환하여 반환한다.
		cnv = JSON.parse(data);
		document.getElementById("access").innerHTML += cnv.name + ", "
				+ cnv.age + ", " + cnv.city;
	</script>
</body>
</html>