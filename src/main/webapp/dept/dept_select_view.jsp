<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="min.dept.dto.DeptDTO, java.util.ArrayList"%>
<%
//속성을 사용하기 위해서는 강제형 변환을 해야한다.
@SuppressWarnings("unchecked")
ArrayList<DeptDTO> arrayList = (ArrayList<DeptDTO>) request.getAttribute("arrayList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부서 관리</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>

</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>부서 관리</h1>
				</div>
			</div>
		</div>
	</header>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>부서 목록</h5>
						</div>
						<div class="card-body">
							<table class="table table-hover">
								<thead class="thead-light">
									<tr class="text-center">
										<th>부서 번호</th>
										<th>부서 이름</th>
										<th>부서 지역</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<%
									for (DeptDTO deptDTO : arrayList) {
									%>
									<tr class="text-center">
										<td><%=deptDTO.getDeptno()%></td>
										<td><%=deptDTO.getDname()%></td>
										<td><%=deptDTO.getLoc()%></td>
										<td><a
											href="./DeptSelectDetail?deptno=<%=deptDTO.getDeptno()%>"
											class="btn btn-outline-info"> 부서 상세 보기 </a></td>
									</tr>
									<%
									}
									%>
									<%
									if (arrayList.size() <= 0) {
									%>
									<tr>
										<td colspan="4">등록된 부서가 없습니다.</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
							<div>
								<a href="./DeptInsert" class="btn btn-success btn-block"> 부서
									입력 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>