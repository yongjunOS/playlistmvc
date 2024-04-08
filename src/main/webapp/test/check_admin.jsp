<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 확인</title>
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
			<div class="card-body">
				<%--다중 조건을 처리한다.--%>
				<c:choose>
					<%--아이디의 값이 null일 때 조건을 실행한다.--%>
					<c:when test="${empty param.id}">
						<form action="#" method="get" id="signupForm">
							<fieldset>
								<div class="form-group row">
									<label for="id" class="ml-sm-3 col-form-label"> 아이디 </label>
									<div class="ml-sm-3">
										<input type="text" name="id" id="id" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-sm">
										전송</button>
									<button type="reset" class="btn btn-primary btn-sm">
										취소</button>
								</div>
							</fieldset>
						</form>
					</c:when>
					<%--아이디의 값이 admin일 때 조건을 실행한다.--%>
					<c:when test="${param.id=='admin'}"> 관리자로 로그인했습니다. </c:when>
					<%--조건이 만족하지 않을 때 실행한다.--%>
					<c:otherwise> ${param.id}로 로그인했습니다.</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
</body>
</html>