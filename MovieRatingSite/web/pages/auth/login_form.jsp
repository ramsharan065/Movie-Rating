<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/errorCheck.js"></script>
<title>Movie Rating Site</title>
</head>
<body>

<div id="wrapper">
    <div id="header"></div>
    <div id="container">
       <div id="misc">
           <form name="loginForm" method="post"
						action="${pageContext.request.contextPath}/auth/login" onsubmit="return loginValidate();">
						<p>Login Form</p>
						<m:onlyOne type="empty">some fields are empty</m:onlyOne>
						<m:onlyOne type="not_matched">Username or password is not matched</m:onlyOne>
						<p>
							<label>Username</label><br /> <input type="text" name="username"
								placeholder="Username" value="${username }"
								autofocus="autofocus" autocomplete="on" /><span id="usernameError"></span>
						</p>
						<p>
							<label>Password</label><br /> <input type="password"
								name="password" placeholder="Password" /><span id="passwordError"></span>
						</p>
						<p>
							<input type="checkbox" name="remember" value="true" /><label>Remember me</label>
						</p>
						<input id="submitButton" type="submit" value="login" />
					</form>



       </div>


        <div>
    <div id="footer"></div>
 </div>

</body>
</html>
