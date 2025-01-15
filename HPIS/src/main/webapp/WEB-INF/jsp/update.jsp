<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新病人信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>门诊挂号与信息管理系统</h1>
		</div>
	   
		<div class="content">
			<h2>更新用户信息</h2>
			<form action="${pageContext.request.contextPath}/patient/update.do" method="post" onsubmit="return check()" class="contact_form">
				<input type="hidden" name="id" value="${patient.id}"  />
				<ul>
					<li class="usually">
						<span>用户名：</span>
						<input type="text" name="name" value="${patient.name}" />
					</li>
					
					<li class="usually">
						<span>年龄：</span>
						<input type="text" name="age" value="${patient.age}" />
					</li>
					
					<li class="usually">
						<span>性别： </span>
						<input type="radio" name="sex" value="m" class="information"  ${patient.sex=="m" ? "checked":""} id="male"/>
						<label for="male">男</label>
						<input type="radio" name="sex" value="f" class="information"  ${patient.sex=="f" ? "checked":""} id="female"/>
						<label for="female">女</label>
					</li>
					
					<li class="usually">
						<span>账号：</span>
						<input type="text" name="account" value="${patient.account}" />
					</li>
					
					<li class="usually">
						<span>密码：</span>
						<input type="text" name="password" value="${patient.password}" />
					</li>
					
					<li class="usually">
						<span>类型：</span>
						<select name="typeId">
							<option value="1" ${patient.type.id==1 ? "selected":""}>管理员</option>
							<option value="2" ${patient.type.id==2 ? "selected":""}>用户</option>
						</select> 
					</li>
					    
					<li>
						<input type="submit" value="修改" class="submit" />
					</li>
				</ul>            
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>