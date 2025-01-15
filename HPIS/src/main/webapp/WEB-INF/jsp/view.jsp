<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门诊挂号与信息管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/view.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>门诊挂号与信息管理系统</h1>
		</div>
	
		<div class="content">
			<p>${account.type.name}：${account.account}&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout.do">注销</a></p>
		   
			<c:if test="${account.type.id==1}">
				<form action="${pageContext.request.contextPath}/patient/find.do" method="post" class="formclass">
					<input type="hidden" name="operation" value="find" />     
					id: <input type="text" name="id" value="" class="information"/>
					name: <input type="text" name="name" value="" class="information"/>
					age: <input type="text" name="age" value="" class="information"/>
					<input type="submit" value="查询" class="btn"/>
				</form>
			  
				<a href="${pageContext.request.contextPath}/patient/addpage.do">添加</a>
			
				<h2>患者信息列表</h2>
				<table border="1">
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>年龄</td>
						<td>性别</td>
						<td>账户</td>
						<td>密码</td>
						<td>类型</td>
						<td colspan="2">操作</td>
					</tr>
				    
					<c:forEach items="${patientList}" var="patient">
					<tr>
						<td>${patient.id}</td>
						<td>${patient.name}</td>
						<td>${patient.age}</td>		           
						<td>${patient.sex=='m'?"男":"女"}</td>
						<td>${patient.account}</td>
						<td>${patient.password}</td>
						<td>${patient.type.name}</td>
						<td><a href="${pageContext.request.contextPath}/patient/delete.do?id=${patient.id}">删除</a></td>
						<td><a href="${pageContext.request.contextPath}/patient/getbyid.do?id=${patient.id}">更新</a></td>
					</tr>					
					</c:forEach>
				</table>
			</c:if>
		   
			<c:if test="${account.type.id==2}">
				<h2>用户信息</h2>
				<table border="1">
					<tr>
					    <td>编号</td>
					    <td>名称</td>
					    <td>年龄</td>
					    <td>性别</td>
					    <td>账户</td>
					    <td>密码</td>
					    <td>类型</td>
					</tr>
				    
					<tr>
						<td>${account.id}</td>
						<td>${account.name}</td>
						<td>${account.age}</td>		           
						<td>${account.sex=='m'?"男":"女"}</td>
						<td>${account.account}</td>
						<td>${account.password}</td>
						<td>${account.type.name}</td>
					</tr>
				</table>
				<h2>门诊挂号</h2>
			    <form action="${pageContext.request.contextPath}/registration/registration.do" method="post" class="formclass">
			        <input type="hidden" name="operation" value="register" />
			        <label for="doctorId">选择医生：</label>
			        <select name="doctorId" required class="information">
			           
			            <option value="">-- 选择医生ID --</option>
			            <c:forEach var="doctor" items="${doctorList}">
			                <option value="${doctor.id}">${doctor.id}</option>
			            </c:forEach>
			        </select>
			        
			        <label for="date">挂号日期：</label>
			        <input type="date" name="date" required class="information" />
			        
			        <input type="submit" value="挂号" class="btn"/>
			        
			        <c:if test="${not empty msg}">
    					<div class="alert alert-info">${msg}</div>
					</c:if>
			    </form>
			     <button onclick="location.href='${pageContext.request.contextPath}/registration/queryReg.do'" class="btns">查看挂号记录</button>
			    <h2>医生信息</h2>
				<table border="1">
					<tr>
						<td>医生ID</td>
						<td>姓名</td>
						<td>科室</td>
						<td>联系电话</td>
						<td>邮箱</td>
						<td>性别</td>
					</tr>
				    
					<c:forEach items="${doctorList}" var="doctor">
					<tr>
						<td>${doctor.id}</td>
						<td>${doctor.name}</td>        
						<td>${doctor.specialty}</td>
						<td>${doctor.contactNumber}</td>
						<td>${doctor.email}</td>
						<td>${doctor.gender}</td>	
					</tr>					
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>