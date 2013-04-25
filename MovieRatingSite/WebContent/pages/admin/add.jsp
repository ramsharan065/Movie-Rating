<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Movie Rating</title>


<!-- CSS -->
<link href="${pageContext.request.contextPath}/pages/admin/layout.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/reset.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/jNice.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/ie7.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/ie6.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/hack.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/pages/admin/transdim.css" rel="stylesheet" type="text/css" media="screen" />

<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jNice.js"></script>
</head>

<body>
	<div id="wrapper">
    	
    	<h1><a href="#"><span>Movie Rating</span></a></h1>
        
       
        <ul id="mainNav">
        	<li><a href="index.jsp" class="active">DASHBOARD</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="#">VIEW</a></li>
        	<li><a href="#">EDIT</a></li>
        	<li><a href="#">ADD</a></li>
        	<li><a href="#">DELETE</a></li>
        	<li class="logout"><a href="#">LOGOUT</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="#">Please fill up...</a></li>
                    	
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
               <form action="${pageContext.request.contextPath}/AdminAddServlet" name="frm" method="post" enctype="multipart/form-data" class="jnice">
               <fieldset>
                        	<p><label>Name:</label></p><p><input type="text" name="fname" class="text-long" /></p>
                        	<p><label>Release Date:</label></p><p><input type="text" name="rdate" class="text-long" /></p>
<!--                            <p><label>Description:</label></p><p><input type="text" name="desc" class="text-long" /></p> -->
                           <p><label>Description:</label></p><p><textarea  name="desc" " rows="10" cols="30"></textarea>
                           <p><label>Image:</label></p><p><input type="file" name="file" id ="file" class="text-long" />
                           <p><label>Video:</label></p><p><input type="text" name="video" class="text-long" /></p>
                           <p><label>Writer:</label></p><p><input type="text" name="writer" class="text-long" /></p>
                           <p><label>Producer:</label></p><p><input type="text" name="producer" class="text-long" /></p>
                           <p><label>Director:</label></p><p><input type="text" name="director" class="text-long" /></p>
<!--                            <p><label>Download Count:</label></p><p><input type="text" name="dcount" class="text-long" /></p> -->
                            <input type="submit" value="Add" />
                        </fieldset>
                    </form>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        <div>
        <p id="footer">Thank you for visiting the movierating admin part</p>
    </div>
    <!-- // #wrapper -->
</body>
</html>

