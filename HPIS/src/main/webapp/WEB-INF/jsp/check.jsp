<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<head>
<meta charset="UTF-8">
<title>挂号记录</title>
</head>
<body>
		<h2>用户挂号记录</h2>
				<table border="1">
					<tr>
						<td>挂号ID</td>
						<td>用户ID</td>
						<td>医生ID</td>
						<td>挂号时间</td>
					</tr>
				    
					<c:forEach items="${registrationList}" var="registration">
					<tr>
						<td>${registration.id}</td>
						<td>${registration.patientId}</td>
						<td>${registration.doctorId}</td>		           
						<td>${registration.date}</td>
						<td>
				    <div class="delete-link">
				        <a href="${pageContext.request.contextPath}/registration/deleteReg.do?id=${registration.id}">删除</a>
				    </div>
</td>
					</tr>					
					</c:forEach>
				</table>
</body>
</html>