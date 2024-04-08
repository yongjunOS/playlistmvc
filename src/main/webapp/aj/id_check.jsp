<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#dbidCheck").click(function() {
			var id = $('#id').val();
			//아이디 입력값이 비어있을 때 처리하지 않고 종료한다.
			if (id.trim() === "") {
				return;
			}
			$.ajax({
				url : '../IdCheck',
				type : 'get',
				data : {
					"id" : id
				},
				success : function(result) {
					console.log("아이디 값 - " + result);
					if ($.trim(result) == 1) {
						alert("등록할 수 있는 아이디입니다.");
						$("#id").focus();
					}
					if ($.trim(result) == 0) {
						alert("이미 등록된 아이디입니다.");
						$('#idCheck').val("1");
						$("#name").focus();
					}
				}
			});
		});
		// 아이디 입력값이 변경하면 이벤트를
		발생시킨다.$("input[id='id']").on("change", function() {
			$("#idCheck").val(1);
		});
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<form id="signupForm">
			<fieldset>
				<div class="form-group row form-inline">
					<label for="id" class="ml-sm-3 col-form-label"> 아이디 </label>
					<div class="ml-sm-3">
						<input type="text" name="id" id="id" class="form-control mr-sm-2">
					</div>
					<button type="button" class="btn btn-outline-secondary"
						id="dbidCheck">아이디 체크</button>
					<input type="hidden" name="idCheck" id="idCheck">
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>