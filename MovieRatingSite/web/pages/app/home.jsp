<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello div <br/>${((user.role eq null)?"guest":user.role) }</h1>
<m:onlyOne type="admin">i am admin</m:onlyOne>
<m:onlyOne type="user">i am user</m:onlyOne>
<m:onlyOne type="guest">i am guest</m:onlyOne>
</body>
</html>