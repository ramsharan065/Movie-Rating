<%@include file="../include/header.jsp" %>

          <div id="login" >
           <form name="loginForm" method="post"
						action="${pageContext.request.contextPath}/auth/login" onsubmit="return loginValidate();">
						<p><strong>Login Form</strong></p>
						<m:onlyOne type="empty">some fields are empty</m:onlyOne>
						<m:onlyOne type="not_matched">Username or password is not matched</m:onlyOne>
						<p>
							<label>Username :: </label><br /> <input type="text" name="username"
								placeholder="Username" value="${username }"
								autofocus="autofocus" autocomplete="on" /><span id="usernameError"></span>
						</p>
						<p>
							<label>Password :: </label><br /> <input type="password"
								name="password" placeholder="Password" /><span id="passwordError"></span>
						</p>
						<p>
							<input type="checkbox" name="remember" value="true" /><label>Remember me</label>
						</p>
						<input id="submitButton" type="submit" value="login" />
					</form>

           </div>


<%@include file="../include/footer.jsp" %>