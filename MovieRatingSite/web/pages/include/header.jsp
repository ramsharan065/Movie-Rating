<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Movie Rating</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/errorCheck.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />





</head>
<body>

<div id="wrapper">
    <div id="header">
        <div id="logo">
            <img src="${pageContext.request.contextPath}/resources/images/header.png"
                 onmouseover="this.src='${pageContext.request.contextPath}/resources/images/header_mover.png';"
                 onmouseout="this.src='${pageContext.request.contextPath}/resources/images/header.png';" />
            <h4>#1 movie rating site ... </h4>
        </div>
        <div id="banner">

            <div id="searchBar">

                <form action="" enctype="multipart/form-data" id="">
                    <input type="text" id="search" placeholder="Movie,Actors" value="Movie,Actors..">
                    <input type="submit" value="Search" title="Search">


                </form>


            </div>

            <div id="profile">
                <m:onlyOne type="admin">

                    <div class="userChoose">
                        <a href="${pageContext.request.contextPath }/auth/logout" ><input type="button" value="LOGOUT" name="logout" id="logoutadmin"></a>
                        <a href="register"><input type="button" value="DASHBARD" name="dashboard" id="dashboard"></a>
                    </div><br/>
                    ${user.name}
                </m:onlyOne>
                <m:onlyOne type="user">
                    <div class="userChoose">
                        <a href="${pageContext.request.contextPath }/auth/logout"><input type="button" value="LOGOUT" name="logout" id="logout"></a>
                    </div><br/>
                    ${user.name}
                </m:onlyOne>

                <m:onlyOne type="guest">
                    <div class="userChoose">
                        <a href="${pageContext.request.contextPath }/auth/signup"><input type="button" value="REGISTER" name="register" id="register"></a>
                        <a href="${pageContext.request.contextPath }/auth/login"><input type="button" value="LOGIN" name="login" id="login"></a>
                    </div>

                </m:onlyOne> </div>

        </div>

    </div>
