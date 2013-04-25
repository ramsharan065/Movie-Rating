<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Movie Rating</title>

<!-- CSS -->
<link href="${pageContext.request.contextPath}/pages/admin/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jNice.js"></script>
</head>

<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>MOVIE RATING</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="#" class="active">DASHBOARD</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="${pageContext.request.contextPath}/AdminAddServlet">ADD</a></li>
<!--         	<li><a href="#">EDIT</a></li> -->
        	<li><a href="#">CHANGE PASSWORD</a></li>
        	<li class="logout"><a href="#">LOGOUT</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="#">>>></a></li>
                    
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Dashboard</a> &raquo; <a href="#" class="active">Movie Details</a></h2>
                
                <div id="main">
                	<form action="" class="jNice">
					<h3>NAME
					
							</h3>
                    	<table cellpadding="0" cellspacing="0">
                    		 <c:forEach var="movie" items="${movies}" >
							<tr>
						
                                
                                
                          <td>  ${movie.name}</td>
                            
                         
                                <td class="action"><a href="AdminViewServlet?id=${movie.id }" class="view">View</a><a href="AdminEditServlet?id=${movie.id}" class="edit">Edit</a><a href="AdminDeleteServlet?id=${movie.id }" class="delete">Delete</a></td>
                            </tr> 
                            </c:forEach>
                             </table>
					
                        
                    </form>
                            
                            
                            
                            
                            
                                                   
<!-- 							<tr class="odd"> -->
<!--                                 <td>MOVIE DESCRIPTION GOES HERE</td> -->
<!--                                 <td class="action"><a href="#" class="view">View</a><a href="edit.jsp" class="edit">Edit</a><a href="#" class="delete">Delete</a></td> -->
<!--                             </tr>                         -->
							                      
							                     
<!-- 							<tr> -->
<!--                                 <td>this is is </td> -->
<!--                                 <td class="action"><a href="#" class="view">View</a><a href="edit.jsp" class="edit">Edit</a><a href="#" class="delete">Delete</a></td> -->
<!--                             </tr>                         -->
                       
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">Thank you for visiting us</p>
    </div>
    <!-- // #wrapper -->
</body>
</html>

















