<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재생목록 수정</title>
<!-- 부트스트랩 CDN 링크 -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 커스텀 스타일 -->
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh; /* 화면 전체 높이를 차지하도록 설정 */
}

/* 카드 스타일 */
.card {
	width: 400px; /* 카드 너비 지정 */
	padding: 20px; /* 내부 여백 설정 */
}
</style>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h5>재생목록 수정</h5>
			</div>
			<div class="card-body">
				<form action="./PlayListUpdateView.pl" method="post"
					id="sign_platlists">
					<fieldset>
						<!-- PLAYLIST_NUM hidden input 추가 -->
						<input type="hidden" name="PLAYLIST_NUM"
							value="${param.PLAYLIST_NUM}">

						<!-- PLAYLIST_NUM hidden input 추가 -->
						<input type="hidden" name="USER_ID" value="${param.USER_ID}">

						<div class="form-group">
							<label for="PLAYLIST_TITLE"> 재생목록 제목</label> <input type="text"
								name="PLAYLIST_TITLE" id="PLAYLIST_TITLE"
								class="form-control form-control-sm bg-white"
								value="${param.PLAYLIST_TITLE}">
						</div>
						<div class="form-group">
							<label for="PLAYLIST_DESCRIPTION">재생목록 설명</label> <input
								type="text" name="PLAYLIST_DESCRIPTION"
								id="PLAYLIST_DESCRIPTION"
								class="form-control form-control-sm bg-white"
								value="${param.PLAYLIST_DESCRIPTION}">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btn-block">등록</button>
							<button type="reset" class="btn btn-secondary btn-block">취소</button>
						</div>
						<div>
							<a href="./PlayListSelect.pl" class="btn btn-primary btn-block">재생목록보기</a>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
