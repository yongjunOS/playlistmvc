<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap.min_4.5.0.css">
<script src="../js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("input[name='fileName']").change(function() {
			var str = $(this).val();
			// 파일명을 축출하여 할당한다.
			var fileName = str.split('\\').pop().toLowerCase();
			checkFileName(fileName);
		});
	});
	function checkFileName(str) {
		// 파일 확장자를 축출하여 할당한다.
		var extension = str.split('.').pop().toLowerCase();
		//배열에 확장자가 있는지 검사하고 배열 안의 확장자가 아니면 false를 반환한다.
		if ($.inArray(extension, [ 'jpg', 'png', 'jpeg', 'gif' ]) == -1) {
			alert(extension + '파일은 업로드 하실 수 없습니다.');
			// 파일명을 다시 지운다.
			$("#file").val("");
			return;
		}
		// 파일명에 공백문자와 특수문자를 정규식으로 검사한다.
		var pattern = /[\s\{\}\/?,;:|*~`!^\+<>@\#$%&\\\=\'\"]/;
		if (pattern.test(str)) {
			alert('파일명에 공백문자와 특수문자를 제거해주세요.');
			$("#file").val("");
			return;
		}
	}
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<div class="row">
			<div class="col-md-5">
				<div class="card-body">
					<%--파일 업로드에 필요한 enctype을 설정하고 POST 메서드로 전송해야 한다.--%>
					<form action="../ImageThum" method="post"
						enctype="multipart/form-data" id="signupForm">
						<fieldset>
							<div class="form-group row">
								<div class="ml-sm-4">
									<input type="file" name="fileName" id="file"
										class="form-control-file">
								</div>
							</div>
							<div class="form-group ml-sm-2">
								<button type="submit" class="btn btn-primary btn-sm"
									onchange="return fileValidation( );">전송</button>
								<button type="reset" class="btn btn-primary btn-sm">취소
								</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

