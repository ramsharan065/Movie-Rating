package com.lf.movie.admin.controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lf.movie.admin.dao.MovieDao;
import com.lf.movie.admin.dto.Movie;

/**
 * Servlet implementation class AdminEditServlet
 */
@WebServlet("/AdminEditServlet")
public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie movie = new Movie();
        movie.setid(Integer.parseInt(request.getParameter("id")));
        

        MovieDao movieedit = new MovieDao();
        
        System.out.println("movie update servlet");
    
        try {
			movie=movieedit.editmovie(movie.getid());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        System.out.println(movie.getname());
       RequestDispatcher dispatcher =request.getRequestDispatcher("/pages/admin/edit.jsp");
        request.setAttribute("movies",movie);
        dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session=request.getSession();
		 System.out.println("update do post method");
		Movie movie = new Movie();
		
		 movie.setname(request.getParameter("name"));
       movie.setid(Integer.parseInt(request.getParameter("getid")));//gets the id from edit jsp page
       
         movie.setrelease_date(request.getParameter("rdate"));
         movie.setdesc(request.getParameter("desc"));
         movie.setdirector(request.getParameter("director"));
         movie.setproducer(request.getParameter("producer"));
         movie.setwriter(request.getParameter("writer"));
         MovieDao movieupdate = new MovieDao();
        
       

         try {
			movieupdate.updateMovie(movie);
		} catch (Exception e) {
			e.printStackTrace();
	}
         response.sendRedirect(request.getContextPath()+"/AdminHome");
       
	}

}
