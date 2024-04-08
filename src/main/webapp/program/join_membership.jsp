<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<%--포워드로 전송할 경우 스타일시트와 자바스크립트를 지원하기 위해 경로를 현재 작업 디렉터리로 변경한다.--%>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
</head>
<body>
	<section id="member">
		<div class="container p-3 my-3">
			<div class="row">
				<div class="col-md-5">
					<div class="card">
						<div class="card-header">
							<h4>회원 가입</h4>
						</div>
						<div class="card-body">
							<form action="./JoinMembership" method="post" id="signupForm">
								<fieldset>
									<div class="form-group row">
										<label for="name" class="ml-sm-4 col-form-label"> 이름 </label>
										<div class="ml-sm-4">
											<input type="text" name="name" id="name"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="ml-sm-3 col-form-label">
											아이디 </label>
										<div class="ml-sm-3">
											<input type="text" name="id" id="id"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="ml-sm-2 col-form-label">
											비밀번호 </label>
										<div class="ml-sm-2">
											<input type="password" name="password" id="password"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="pwdre" class="ml-sm-2 col-form-label">
											비번확인 </label>
										<div class="ml-sm-2">
											<input type="password" name="pwdre" id="pwdre"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="gender" class="ml-sm-4 form-check-label">
											성별 </label>
										<div class="ml-sm-4 form-check form-check-inline">
											<input type="radio" name="gender" id="gender" value="m"
												class="form-check-input" checked>남자 <input
												type="radio" name="gender" id="gender" value="f"
												class="ml-sm-3 form-check-input">여자
										</div>
									</div>
									<div class="form-group row">
										<label for="hobby" class="ml-sm-4 form-check-label">
											취미 </label>
										<div class="ml-sm-4 form-check form-check-inline">
											<input type="checkbox" value="축구" name="hobby" id="hobby"
												class="form-check-input" checked>축구 <input
												type="checkbox" value="야구" name="hobby" id="hobby"
												class="ml-sm-3 form-check-input">야구 <input
												type="checkbox" value="농구" name="hobby" id="hobby"
												class="ml-sm-3 form-check-input">농구
										</div>
									</div>
									<div class="form-group">
										<button type="submit" id="register"
											class="btn btn-primary btn-sm">등록</button>
										<button type="reset" id="cancel"
											class="btn btn-primary btn-sm">취소</button>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>