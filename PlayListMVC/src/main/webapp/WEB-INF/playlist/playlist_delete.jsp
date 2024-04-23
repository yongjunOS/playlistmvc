<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재생목록 삭제</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.container {
	width: 50%;
	margin: 50px auto;
}

fieldset {
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
}

legend {
	font-size: 24px;
	font-weight: bold;
	text-align: center;
	margin-bottom: 20px;
	position: absolute;
	top: 20px;
	left: 50%;
	transform: translateX(-50%);
}

.form-group {
	margin-bottom: 20px;
}

input[type="text"] {
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<form action="./PlayListDelete.pl" method="post" id="sign_dept">
			<fieldset>
				<legend>재생목록 삭제</legend>
				<div class="form-group row">
					<label for="PLAYLIST_NUM"
						class="col-sm-3 col-form-label text-right">재생목록 번호</label>
					<div class="col-sm-9">
						<input type="text" name="PLAYLIST_NUM" id="PLAYLIST_NUM"
							class="form-control" value="${param.PLAYLIST_NUM}" readonly>
					</div>
				</div>
			</fieldset>
			<div class="btn-group">
				<button type="submit" class="btn btn-danger">삭제</button>
				<button type="button" class="btn btn-secondary" onclick="goBack()">뒤로</button>
			</div>
		</form>
	</div>

	<script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
