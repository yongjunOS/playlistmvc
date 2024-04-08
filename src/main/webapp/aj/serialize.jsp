<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배열 형태 변환</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#register").click(function() {
			$("#result").empty();
			// 폼 데이터를 배열 형태로 변환한다.
			form_data = $("form").serializeArray();
			$("#result").text(form_data);
			console.log(form_data);
			$.each(form_data, function(index, value) {
				$("#result").append("<br>" + value.name + "=" + value.value);
			});
			return false;
		});
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<form action="#" method="get" id="signupForm">
			<fieldset>
				<div class="form-group row">
					<label for="name" class="ml-sm-4 col-form-label"> 이름 </label>
					<div class="ml-sm-4">
						<input type="text" name="name" id="name" class="form-control">
					</div>
				</div>
				<div class="form-group row">
					<label for="age" class="ml-sm-4 col-form-label"> 나이 </label>
					<div class="ml-sm-4">
						<input type="text" name="age" id="age" class="form-control">
					</div>
				</div>
				<button type="submit" id="register" class="btn btn-primary btn-sm">
					전송</button>
			</fieldset>
		</form>
	</div>
	<div class="container p-3 my-3 border" id="result"></div>
</body>
</html>