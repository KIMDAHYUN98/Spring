<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/deptInsert.jsp</title>
</head>
<body>
<h3 id="top">부서등록</h3>
<c:set var="url" value="deptInsert"/>
<form action="${url}" method="post" name="frm">
	department_id    <input name="department_id" value="${deptVO.department_id }"><br>
	department_name    <input name="department_name" value="${deptVO.deparment_name }"><br>
	manager_id    
	<select name="manager_id">
		<c:forEach items="${deptList }" var="dept">
			<option>${dept.manager_id }</option>
		</c:forEach>
	</select><br>
	location_id
	<c:forEach items="${deptList }" var="dept">
		<input name="location_id" type="radio" value="${dept.location_id }">${dept.location_id }
	</c:forEach><br><br>
	
	<button type="submit">등록</button>
	<button type="reset">취소</button>
</form>
</body>
</html>