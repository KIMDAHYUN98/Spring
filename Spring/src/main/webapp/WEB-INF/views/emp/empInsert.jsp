<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	// 이메일 중복체크
	$('#btnEmail').on("click", function() {
		$.ajax({
			url : '../EmailCheck',
			data : "email=" + ﻿$("[name=email]").val(), // 서버에 보낼 파라미터
			dataType : "xml", 						   // 결과 타입
			success: function(response) {
				//span 태그에 출력
				/* json
				if(response.email == true) {
				$('#emailResult').html("<font color='blue'>사용가능></font>");						
				} else {
				$('#emailResult').html("<font color='blue'>사용불가능></font>");
				}*/
				
				// xml (= html 태그 찾는 법과 동일)
				// 태그안에 있는 값을 읽어오는데..
				$('#emailResult').html($(response).find("email").text()) // jquery 함수
			},
		})
	})
})
</script>
</head>
<body>
<h3 id="top">사원등록</h3>
<c:set var="url" value="./empInsert" />
<c:if test="${not empty empVO.employee_id }">
<c:set var="url" value="./empUpdate" />
</c:if>
<form action="${url}" method="post" name="frm">
	employee_id <input type="number" name="employee_id"
				<c:if test="${not empty empVO.employee_id }">readonly="readonly"</c:if> value="${empVO.employee_id }"><br>
	first_name  <input name="first_name" value="${empVO.first_name }" ><br>
	last_name   <input name="last_name" value="${empVO.last_name }"><br>
	email       <input type="email" name="email" value="${empVO.email }">
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number" value="${empVO.phone_number }"><br>
	hire_date   <input type="date" name="hire_date" value="${empVO.hire_date }"><br>
	job_id
	<select name="job_id">
	<c:forEach items="${jobList }" var="job" >
		<option value="${job.job_id}" selected="selected" }> ${job.job_title }</option>
	</c:forEach>
	</select><br>
	department_id<br>
	<c:forEach var="dept" items="${deptList }">
	<input type="radio" name="department_id" value="${dept.department_id }"
	<c:if test="${dept.department_id == empVO.department_id}"> checked="checked" </c:if>>
	${dept.department_name }	
	</c:forEach><br>
	manager_id 
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" onclick="window.open('empSearch', 'emp', 'width=400, height=400')">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>

</body>
</html>
