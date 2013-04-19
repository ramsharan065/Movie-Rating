<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<p>
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