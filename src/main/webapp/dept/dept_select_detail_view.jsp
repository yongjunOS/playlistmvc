<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> 상세 부서 정보 </title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
 <header id="main-header" class="py-2 btn-dark text-white">
  <div class="container">
   <div class="row">
    <div class="col-md-6">
     <h1>상세 부서 정보</h1>
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
       <h5>부서 상세 보기</h5>
      </div>
      <div class="card-body">
       <table class="table table-hover">
        <thead class="thead-light">
         <tr class="text-center">
          <th>부서 번호</th>
          <th>부서 이름</th>
          <th>부서 지역</th>
         </tr>
        </thead>
        <tbody>
         <tr class="text-center">
          <td><%=request.getParameter("deptno")%></td>
          <td><%=request.getAttribute("dname")%></td>
          <td><%=request.getAttribute("loc")%></td>
         </tr>
        </tbody>
       </table>
       <div class="row">
        <div class="col-md-4">
         <a href="./DeptSelect" class="btn btn-primary btn-block"> 부서 목록 </a>
        </div>
        <div class="col-md-4">
         <a href="./DeptUpdate?deptno=<%=request.getParameter("deptno")%>" class="btn btn-warning btn-block"> 부서 수정 </a>
        </div>
        <div class="col-md-4">
         <a href="./DeptDelete?deptno=<%=request.getParameter("deptno")%>" class="btn btn-danger btn-block"> 부서 삭제 </a>
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </section>
</body>
</html>