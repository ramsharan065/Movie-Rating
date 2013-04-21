<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Movie Rating Site</title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="logo">Movie Rating</div>
		</div>
		<div id="body">
			<div id="login">
				<div id="loginForm" style="">
					<form method="post"
						action="${pageContext.request.contextPath}/auth/login">
						<p>Login Form</p>
						<m:authError type="empty">some fields are empty</m:authError>
						<m:authError type="not_matched">Username or password is not matched</m:authError>
						<p>
							<label>Username</label><br /> <input type="text" name="username"
								placeholder="Username" value="${username }"
								autofocus="autofocus" autocomplete="on" />
						</p>
						<p>
							<label>Password</label><br /> <input type="password"
								name="password" placeholder="Password" />
						</p>
						<input id="submitButton" type="submit" value="login" />
					</form>
				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>