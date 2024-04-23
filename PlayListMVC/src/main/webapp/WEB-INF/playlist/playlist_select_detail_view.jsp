<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재생목록 상세 정보</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.container {
	width: 80%;
	margin: 20px auto;
	text-align: center;
}

.table {
	width: 80%;
	margin: 20px auto;
}

.table th, .table td {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="my-4">재생목록 상세 정보</h2>
		<div class="row justify-content-center mb-3">
			<div class="col-md-2">
				<a href="./PlayListSelect.pl"
					class="btn btn-primary btn-sm btn-block">재생목록 보기</a>
			</div>
			<div class="col-md-2">
				<a
					href="./PlayListUpdate.pl?PLAYLIST_NUM=${playListDTO.PLAYLIST_NUM}&USER_ID=${playListDTO.USER_ID}"
					class="btn btn-warning btn-sm btn-block">재생목록 수정</a>
			</div>
			<div class="col-md-2">
				<a
					href="./PlayListDeleteView.pl?PLAYLIST_NUM=${playListDTO.PLAYLIST_NUM}&USER_ID=${playListDTO.USER_ID}"
					class="btn btn-danger btn-sm btn-block">재생목록 삭제</a>
			</div>
		</div>
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">재생목록 번호</th>
					<th scope="col">사용자 ID</th>
					<th scope="col">재생목록 제목</th>
					<th scope="col">재생목록 설명</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${playListDTO.PLAYLIST_NUM}</td>
					<td>${playListDTO.USER_ID}</td>
					<td>${playListDTO.PLAYLIST_TITLE}</td>
					<td>${playListDTO.PLAYLIST_DESCRIPTION}</td>
				</tr>
			</tbody>
		</table>

	
	</div>
</body>
</html>
