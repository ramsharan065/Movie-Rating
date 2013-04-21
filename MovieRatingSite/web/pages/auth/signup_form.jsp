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
			<div id="signup">
				<div id="signupForm">
					<form method="post"
						action="${pageContext.request.contextPath}/auth/signup">
						<p>Signup Form</p>
<%-- 						<m:authError type="empty">some fields are empty</m:authError> --%>
<%-- 						<m:authError type="invalid_username">username is invalid</m:authError> --%>
<%-- 						<m:authError type="password_length">password length should be atleast 6</m:authError> --%>
<%-- 						<m:authError type="passwords_not_matched">passwords not matched</m:authError> --%>
						<m:authError type="invalid_input">some fields are empty or have invalid inputs</m:authError>
						<m:authError type="username_already_exists">the username already exists</m:authError>
						
						<p>
							<span>All fields are required</span><br/>
							<label>Full Name</label><br /> <input type="text" name="name"
								placeholder="Full Name" value="${name }" />
						</p>
						<p>
							<label>Username</label><br /> <input type="text" name="username"
								placeholder="Username" value="${username }" />
						</p>
						<p>
							<label>Password</label><br /> <input type="password"
								name="password" placeholder="Password" />
						</p>
						<p>
							<label>Retype Password</label><br /> <input type="password"
								name="rePassword" placeholder="Retype Password" />
						</p>
						<input id="submitButton" type="submit" value="signup" />
					</form>
				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>