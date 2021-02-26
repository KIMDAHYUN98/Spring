<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empList.jsp</title>
</head>
<body>
<h2>사원 목록</h2>
	<c:forEach var="emp" items="${list }">
		${emp.first_name } ${emp.last_name }
		${emp.salary }<br>
	</c:forEach>
</body>
</html>