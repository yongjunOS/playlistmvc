<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% int deptno = Integer.parseInt(request.getParameter("deptno")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 부서 삭제 </title>
</head>
<body>
<script type="text/javascript">
alert("입력하신 <%=deptno %>번의 부서 번호를 삭제하였습니다.")
location.href="./DeptSelect";
</script>
</body>
</html>