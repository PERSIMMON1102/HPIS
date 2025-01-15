<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加病人信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>门诊挂号与信息管理系统</h1>
		</div>
	    
		<div class="content">
			<h2>添加用户信息</h2>
			<form action="${pageContext.request.contextPath}/patient/add.do" method="post" onsubmit="return check()" class="contact_form" >
			<ul>
				<li class="usually">
					<span>姓名：</span>
					<input type="text" name="name" value="" />
				</li>
				
				<li class="usually">
					<span>年龄：</span>
					<input type="text" name="age" value="" id="age"/>
				</li>
				
				<li class="usually">
					<span>性别： </span>
					<input type="radio" name="sex" value="m" id="male"/>
					<label for="male">男</label>
					<input type="radio" name="sex" value="f" id="female"/>
					<label for="female">女</label>
				</li>
				
				<li class="usually">
					<span>账号：</span>
					<input type="text" name="account" value="" class="information"/>
				</li>
				
				<li class="usually">
					<span>密码：</span>
					<input type="text" name="password" value="" class="information"/>
				</li>
				
				<li class="usually">
					<span>类型：</span>
					<select name="typeId">
						<option value="1">管理员</option>
						<option value="2">用户</option>
					</select> 
				</li>
				    
				<li>
					<input type="submit" value="添加" class="submit" />
				</li>
			</ul>            
			</form>
		</div>
	    
	</div>

	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>