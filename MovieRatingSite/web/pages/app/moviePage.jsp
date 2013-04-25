<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>
<div id="container">

    <div id="left">
        <div id="moviepage">

            <h3>WOLVERINE (2013)</h3>
        <img src="${pageContext.request.contextPath}/resources/images/wolverine_light.jpg" alt="X-men , Wolverine">
          <div id="moviedesc">

              <h4><u>Movie Review</u></h4>
           <p>
               Average Review :: 4.3/5   <br/>
               User Ratings :: 4555  <br/>
               Total View :: 12,1345  <br/>
               Year ::2013            <br/>
               Producer :: Michael Bay  <br/>
               Director :: Tony Smith     <br/>
               Cast :: Hugh JackMan, Hally Berry, Charles  <br/>

              </p>

              <h5 >My Rating ::

              <ul class="star-rating">
                  <li class="current-rating" style="width:70%">Currently 2.5/5 Stars.</li>
                  <li><a href="" title="1 star out of 5" class="one-star">1</a></li>
                  <li><a href="" title="2 stars out of 5" class="two-stars">2</a></li>
                  <li><a href="" title="3 stars out of 5" class="three-stars">3</a></li>
                  <li><a href="" title="4 stars out of 5" class="four-stars">4</a></li>
                  <li><a href="www.google.com" title="5 stars out of 5" class="five-stars">5</a></li>
              </ul>
               </h5>       <br/>


              <form action="" method="post">
              <textarea placeholder="Add a review (Optional) "></textarea>
               <input type="submit" value="POST" id="post" name="post">
                </form>
              <br/>
              <hr/>
              MOVIE INFO
              <hr/>
               <h6>
                   Hugh Jackman returns as Wolverine in this sequel
                   to the member of the X-Men's first solo outing.
                   Mark Bomback and The Usual Suspects' Christopher
                   McQuarrie penned the script, which takes its inspiration
                   from the Chris Claremont/Frank Miller Marvel miniseries
                   from the 1980s dealing with the character's adventures in
                   Japan as he fights ninjas in the
                   ceremonial garb of the samurai. Knight and Day's James
                   Mangold directs. ~ Jeremy Wheeler, Rovi


               </h6>

          </div>
             <div id="movievideo">


                 <object width="330" height="280">
                     <param name="movie" value="http://www.youtube.com/v/Rh1LdTFkm7I"></param>
                     <param name="wmode" value="transparent"></param>
                     <embed src="http://www.youtube.com/v/Rh1LdTFkm7I" type="application/x-shockwave-flash" wmode="transparent" width="330" height="280"></embed>
                 </object>
             </div>
        </div>

        </div>
        <%@include file="../include/right.jsp" %>
    </div>









<%@include file="../include/footer.jsp" %>