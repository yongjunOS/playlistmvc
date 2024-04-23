<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재생목록 만들기</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
/* 스타일을 직접 추가할 수 있습니다. */
body {
	background-color: #f8f9fa;
	font-family: 'Nanum Gothic', sans-serif;
}

#department {
	margin-top: 50px;
}

.card {
	border: none;
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.card-header {
	background-color: #333333;
	color: #fff;
	border-radius: 10px 10px 0 0;
}

.btn-secondary {
	background-color: #6c757d;
	border-color: #6c757d;
}

.btn-secondary:hover {
	background-color: #5a6268;
	border-color: #545b62;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						<h5>재생목록 입력</h5>
					</div>
					<div class="card-body">
						<form action="./PlayListInsert.pl" method="post"
							id="sign_platlists">
							<fieldset>
								<div class="form-group">
									<label for="USER_ID"> 사용자 ID </label> <input type="text"
										name="USER_ID" id="USER_ID" class="form-control">
								</div>
								<div class="form-group">
									<label for="PLAYLIST_TITLE"> 재생목록 제목</label> <input type="text"
										name="PLAYLIST_TITLE" id="PLAYLIST_TITLE" class="form-control">
								</div>
								<div class="form-group">
									<label for="PLAYLIST_DESCRIPTION">재생목록 설명</label> <input
										type="text" name="PLAYLIST_DESCRIPTION"
										id="PLAYLIST_DESCRIPTION" class="form-control">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-secondary btn-block">만들기</button>
									<button type="reset" class="btn btn-secondary btn-block">취소</button>
								</div>
								<div>
									<a href="./PlayListSelect.pl" class="btn btn-primary btn-block">
										재생목록보기 </a>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
