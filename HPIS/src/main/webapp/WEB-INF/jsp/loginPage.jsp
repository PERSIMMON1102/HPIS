<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginPage.css" type="text/css" />
    <style>
        .active {
            color: red; /* 选中状态的颜色 */
        }
    </style>
</head>
<body>
	<div class="head">
	<p>门诊挂号与信息管理系统</p>
    </div>
    <div class="mainContent">
        <div>
            <div class="leftDiv">
                <div class="text1">
                    <p>微信扫码安全登录</p>
                </div>
                <img src="images/scan.png"/>
            </div>
            <div class="loginDiv">
                <p class="headText">
                    <span class="first_login" onclick="showLoginType('account', this)">账号登录</span>
                    <span>&nbsp;&nbsp;&nbsp;</span>
                    <span class="second_login" onclick="showLoginType('sms', this)">短信登录</span>
                </p>
				
                <!-- 账号登录表单 -->
				<form action="${pageContext.request.contextPath}/login.do" method="post" onsubmit="return checkLogin()">
					<div class="login" id="accountLogin">
					    <span>账号</span>
					    <input type="text" name="username" placeholder=" 账号名/手机号/邮箱"/>
					</div>
					<div class="login" id="accountPassword">
					    <span>密码</span>
					    <input type="password" name="password" placeholder=" 密码"/>
					</div>
					
						
                
                <!-- 短信登录表单 -->
                <div class="login" id="smsLogin" style="display: none;">
                    <span>手机号</span>
                    <input type="text" name="tel" placeholder=" 手机号"/>
				</div>
				<div class="login" id="smsPassword" style="display: none;">
                    <span>验证码</span>
                    <input type="text" name="info" placeholder=" 验证码"/>
                </div>
                <p class="info">${msg}</p>
				<a href="#" class="text2">忘记密码</a>
				<input type="submit" value="登录" class="loginBT" />
                
                
                </form>
				<div class="other-login-wrapper">
				    <div class="other-login-item">
				        <img src="images/QQ.png" alt="QQ">
				    </div>
				    <div class="other-login-item">
				        <img src="images/wechat.png" alt="WeChat">
				    </div>
					<a href="#" class="text3">立即注册</a>
				</div>
				
            </div>
        </div>
    </div>
   <script type="text/javascript" src="js/script.js"></script> 
</body>
</html>