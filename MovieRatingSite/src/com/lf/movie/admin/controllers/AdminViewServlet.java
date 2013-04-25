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
 * Servlet implementation class AdminViewServlet
 */
@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewServlet() {
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
       RequestDispatcher dispatcher =request.getRequestDispatcher("/pages/admin/view.jsp");
        request.setAttribute("movies",movie);
        dispatcher.forward(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
