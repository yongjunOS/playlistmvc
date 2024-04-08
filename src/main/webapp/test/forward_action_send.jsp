<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전송</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="../js/jquery.validate.min.js" type="text/javascript"></script>
<script src="../js/validity.js" type="text/javascript"></script>
</head>
<body>
	<section id="member">
		<div class="container p-3 my-3 border">
			<div class="row">
				<div class="col-md-5">
					<div class="card-body">
						<form action="./forward_action.jsp" method="post" id="signupForm">
							<fieldset>
								<%--서버 페이지에서 타입을 재설정한다.--%>
								<input type="hidden" name="page"
									value="./forward_action_view.jsp">
								<div class="form-group row">
									<label for="name" class="ml-sm-4 col-form-label"> 이름 </label>
									<div class="ml-sm-4">
										<input type="text" name="name" id="name"
											class="form-control form-control-sm">
									</div>
								</div>
								<div class="form-group row">
									<label for="id" class="ml-sm-3 col-form-label"> 아이디 </label>
									<div class="ml-sm-3">
										<input type="text" name="id" id="id"
											class="form-control form-control-sm">
									</div>
								</div>
								<div class="form-group ml-sm-2">
									<button type="submit" class="btn btn-primary btn-sm">
										전송</button>
									<button type="reset" class="btn btn-primary btn-sm">
										취소</button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>