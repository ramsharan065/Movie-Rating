<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Movie Rating Site</title>


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
<!--         	<li><a href="add.jsp">ADD</a></li> -->
<!--         	<li><a href="delete.jsp">DELETE</a></li> -->
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
                
               <form action="${pageContext.request.contextPath }/AdminEditServlet" name="frm" method="post" class="jnice">
               <fieldset>
                        	<p><label>Name:</label></p><p><input type="text" name="name"  value="${movies.name}" class="text-long" /></p>
                        	<p><label>Release Date:</label></p><p><input type="text" name="rdate" placeholder="Release Date" value="${movies.release_date }"  class="text-long" /></p>
<%--                            <p><label>Description:</label></p><p><input type="text" name="desc" placeholder="Description" value ="${movies.desc }" class="text-long" /></p> --%>
                          <p><label>Description:</label></p><p><textarea  name="desc"   rows="10" cols="30">${movies.desc}</textarea>
                           <p><label>Image:</label></p><p><input type="text" name="image" class="text-long" value="${movies.image}" /></p>
                           <p><label>Writer:</label></p><p><input type="text" name="writer" value="${movies.writer }" class="text-long" /></p>
                           <p><label>Producer:</label></p><p><input type="text" name="producer" value="${movies.producer }" class="text-long" /></p>
                           <p><label>Director:</label></p><p><input type="text" name="director" value="${movies.director }" class="text-long" /></p>
<!--                            <p><label>Average Rating:</label></p><p><input type="text" name="avg_rating" class="text-long" /></p> -->
<!--                            <p><label>Download Count:</label></p><p><input type="text" name="dcount" class="text-long" /></p> -->
                           <input type="hidden" name="getid" value="${movies.id}"> 
                            <input type="submit" value="Update" />
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
        <p id="footer">Thank you for  visiting us</p>
    </div>
    <!-- // #wrapper -->
</body>
</html>

