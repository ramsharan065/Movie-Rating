<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Rating</title>
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
                  <form class="form-search">
                      <div class="input-append">
                          <input type="text" class="span2 search-query">
                          <button type="submit" class="btn">Search</button>
                      </div>

          </form>
                  </div>

      </div>

  </div>
   <div id="nav">
       <ul class="navi">
           <li><a href="#">Home</a></li>
           <li><a href="#">Latest</a></li>
           <li><a href="#">Top</a></li>
           <li><a href="#">Category</a></li>
           <li class="li1"><a href="#">Contact Us</a></li>
       </ul>





   </div>
    <div id="container">
        <div id="left">
          <div id="rank">

             <table id="ranktable" title="Ranking"   >
                 <tr><td colspan="3" align="center" bgcolor="#b22222"><h4>MOVIE RANKING</h4></td></tr>
                 <tr class="alt"><th>#</th><th>Movie Name</th><th>Average Rating</th></tr>
                 <tr class="alt"><td>1</td><td>G.I joe</td><td>4.7</td></tr>

                 <tr class="alt"><td>2</td><td>terminator</td><td>4.5</td></tr>
                 <tr class="alt"><td>3</td><td>Spiderman</td><td>4.3</td></tr>
                 <tr class="alt"><td>4</td><td>Iron man</td><td>4</td></tr>
                 <tr  class="alt"><td>5</td><td>Superman</td><td>3.9</td></tr>
                 <tr class="alt"><td>6</td><td>Evil Dead</td><td>3.8</td></tr>
                 <tr class="alt"><td>7</td><td>Jail break</td><td>3.7</td></tr>
                 <tr class="alt"><td>8</td><td>life</td><td>3.6</td></tr>
                 <tr class="alt"><td>9</td><td>Bourne</td><td>3.5</td></tr>
                 <tr class="alt"><td>10</td><td>Ice age</td><td>3.4</td></tr>
                 <tr class="alt"><td colspan="3" align="right"><a href="" >More...</a></td></tr>

             </table>

             <div id="nextchange">


                 <div id="upcome">
                    <h4>TOP DOWNLOAD</h4>
                    <img class="media_block_image" width="100" style="margin-right:15px;"
                    title="" alt="" src="http://content7.flixster.com/movie/11/16/82/11168213_det.jpg">
                    <h6><br>
                        Length :: 3 hr   <hr>  <br>
                        Category :: Thrill  <hr>  <br>
                        Director :: Steven Speilberg   <br>  <hr>

                    </h6>
                 </div>

                 <div id="rate">
                     <h6>Rating ::</h6>
                     <ul class="star-rating small-star">
                         <li class="current-rating" style="width:70%">Currently 2.5/5 Stars.</li>
                         <li><a href="#" title="1 star out of 5" class="one-star">1</a></li>
                         <li><a href="#" title="2 stars out of 5" class="two-stars">2</a></li>
                         <li><a href="#" title="3 stars out of 5" class="three-stars">3</a></li>
                         <li><a href="#" title="4 stars out of 5" class="four-stars">4</a></li>
                         <li><a href="#" title="5 stars out of 5" class="five-stars">5</a></li>
                     </ul>
                     <img  src="${pageContext.request.contextPath}/resources/images/downlod.png" alt="Download" title="Download" height="50px" >
                   <br> <p><h5>Cast :: <a href="" >Michelle</a>, <a href=" " >Jolly</a>,<a href="">Terry Jones</a>
                     ,<a href="">Amit</a>,<a href="">ELiza </a>,<a href="">Tedd</a>


                 </h5> </p>
                 </div>
             </div>

          </div>






         <div id="misc">
             <h4><marquee>Welcome to the rotten Apple...</marquee></h4>


                <div id="hotapple" >

                    <table title="TOP OF THE ROTTEN APPLE" border="1" align="left">
                        <tr ><th colspan="3" bgcolor="#a52a2a" >Latest Movies Series </th></tr>
                        <tr><td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/woverine.jpg" width="160px" height="98px" alt="wolverine">
                        <div class="caption">

                            Woverine 3-D

                        </div>




                        </a></td>
                            <td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/gijoe.jpg" width="160px" height="98px" alt="wolverine">
                                <div class="caption">

                                    G-I JOE 2

                                </div>


                            </a></td>
                            <td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/atanyplace.jpg" width="160px" height="98px" alt="wolverine">
                                <div class="caption">

                                    At any Place

                                </div>




                            </a></td>


                        </tr>

                        <tr><td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/paingain.jpg" width="160px" height="98px" alt="wolverine">
                            <div class="caption">

                                Pain-Gain

                            </div>

                        </a></td>
                            <td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/mud.jpg" width="160px" height="98px" alt="wolverine">

                                <div class="caption">

                                    MUD

                                </div>

                            </a></td>
                            <td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/scary.jpg" width="160px" height="98px" alt="wolverine">
                                <div class="caption">

                                    Scary 3-D

                                </div>




                            </a></td>




                        </tr>

                    </table>






                 </div>
             <div id="rotapple">
                 <table title="TOP OF THE ROTTEN APPLE" border="1" align="left">
                     <tr ><th colspan="3" bgcolor="#a52a2a" >TOP Movies Series </th></tr>
                     <tr><td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/saga.jpg" width="160px" height="98px" alt="wolverine">
                         <div class="caption">

                             Twilight Saga

                         </div>




                     </a></td>
                         <td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/django.jpg" width="160px" height="98px" alt="wolverine">
                             <div class="caption">

                                 Django

                             </div>


                         </a></td>
                         <td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/hobbit.jpg" width="160px" height="98px" alt="wolverine">
                             <div class="caption">

                                 Hobbit

                             </div>




                         </a></td>


                     </tr>

                     <tr><td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/lifeofpi.jpg" width="160px" height="98px" alt="wolverine">
                         <div class="caption">

                             Life of pie

                         </div>

                     </a></td>
                         <td><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/skyfall.jpg" width="160px" height="98px" alt="wolverine">

                             <div class="caption">

                                 007-Skyfall

                             </div>

                         </a></td>
                         <td ><a href="" class="prel"><img src="${pageContext.request.contextPath}/resources/images/zerodark.jpg" width="160px" height="98px" alt="wolverine">
                             <div class="caption">

                                 Zero-Dark

                             </div>




                         </a></td>




                     </tr>

                 </table>

                 </div>
                </div>
         </div>
        <div id="right">  <table id="ranktableright" title="Ranking"   >
            <tr><td colspan="3" align="center" bgcolor="#b22222"><h4>LATEST MOVIES</h4></td></tr>
            <tr class="altright"><th>#</th><th>Movie Name</th><th>Age (Days)</th></tr>
            <tr class="altright"><td>1</td><td>G.I joe</td><td>3</td></tr>

            <tr class="altright"><td>2</td><td>terminator</td><td>10</td></tr>
            <tr class="altright"><td>3</td><td>Spiderman</td><td>11</td></tr>
            <tr class="altright"><td>4</td><td>Iron man</td><td>17</td></tr>
            <tr  class="altright"><td>5</td><td>Superman</td><td>31</td></tr>
            <tr class="altright"><td>6</td><td>Evil Dead</td><td>50</td></tr>
            <tr class="altright"><td>7</td><td>Jail break</td><td>51</td></tr>
            <tr class="altright"><td>8</td><td>life</td><td>51</td></tr>
            <tr class="altright"><td>9</td><td>Bourne</td><td>52</td></tr>
            <tr class="altright"><td>10</td><td>Ice age</td><td>53</td></tr>
            <tr class="altright"><td colspan="3" align="right"><a href="" >More...</a></td></tr>

        </table>
            <div id="nextchangeright">


                <div id="upcomeright">
                    <h4>LATEST DOWNLOAD</h4>
                    <img class="media_block_image" width="100" style="margin-right:15px;"
                         title="" alt="" src="http://content8.flixster.com/movie/11/16/56/11165666_det.jpg">
                    <h6><br>
                        Length :: 2 hr   <hr>  <br>
                        Category :: Comedy  <hr>  <br>
                        Director :: Tony Bla   <br>  <hr>

                    </h6>
                </div>

                <div id="rateright">
                    <h6>Rating ::</h6>
                    <ul class="star-rating small-star">
                        <li class="current-rating" style="width:70%">Currently 2.5/5 Stars.</li>
                        <li><a href="#" title="1 star out of 5" class="one-star">1</a></li>
                        <li><a href="#" title="2 stars out of 5" class="two-stars">2</a></li>
                        <li><a href="#" title="3 stars out of 5" class="three-stars">3</a></li>
                        <li><a href="#" title="4 stars out of 5" class="four-stars">4</a></li>
                        <li><a href="#" title="5 stars out of 5" class="five-stars">5</a></li>
                    </ul>
                    <img  src="${pageContext.request.contextPath}/resources/images/downlod.png" alt="Download" title="Download" height="50px" >
                    <br> <p><h5>Cast :: <a href="" >Daniel</a>, <a href=" " >Jenish</a>,<a href="">Tom Larry</a>
                    ,<a href="">Harsha</a>,<a href="">Lee</a>,<a href="">Ponyy</a>


                </h5> </p>
                </div>
            </div>









































        </div>
        </div>
    <div id="footer" >&copy; 2013 Ram,Ranjan,Bijay </div>
    </div>



<h1><br/>${((user.role eq null)?"guest":user.role) }</h1>
<m:onlyOne type="admin">i am admin</m:onlyOne>
<m:onlyOne type="user">i am user</m:onlyOne>
<m:onlyOne type="guest">i am guest</m:onlyOne>

</body>
</html>
