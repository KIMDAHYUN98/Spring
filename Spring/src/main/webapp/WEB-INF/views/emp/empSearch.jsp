<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empSearch.jsp</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function() {
		$('.btnSelect').on("click", function() {
			var empid =$(this).closet("div");
			var firstName = "";
			opener.document.frm.manager_id.value=empid;
			$(opener.document).find('[name=manager_id]').val(empid);
			window.close();
		})
	})
</script>
</head>
<body>
<h3>사원 검색</h3>
	<c:forEach items="${list }" var="emp">
		<div class="row">
			<span>${emp.employee_id }</span>
			<span>${emp.first_name }</span>
			<span>${emp.last_name }</span>
			<span>${emp.hire_date }</span>
			<span><button type="button" class="btnSelect">선택</button></span>
		</div>
	</c:forEach>
</body>
</html>