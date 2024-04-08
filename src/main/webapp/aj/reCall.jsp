<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 Ajax 구현</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	window.onload = function() {
		// 생성자 함수로 XMLHttpRequest 객체를 생성하고
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			// 요청이 완료되면 처리한다.
			if (xhr.readyState == 4) {
				// HTTP 상태 코드가 200~599인 경우에만 처리한다.
				if (xhr.status >= 200 && xhr.status < 600) {
					document.getElementById('call').innerHTML = xhr.responseText;
				}
			}
		}
		xhr.open('GET', './re.jsp');
		xhr.send();
	}
</script>
</head>
<body>
	<div class="container p-3 my-3 border" id="call"></div>
</body>
</html>
