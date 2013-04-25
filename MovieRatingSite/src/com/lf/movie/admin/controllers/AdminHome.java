package com.lf.movie.admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lf.movie.admin.dao.MovieDao;
import com.lf.movie.admin.dto.Movie;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieDao dao = new MovieDao();
		System.out.println("view movies");
		List <Movie>showMovies = new ArrayList<Movie>();
		try {
			showMovies= dao.getMovie();
			RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/admin/index.jsp");
			request.setAttribute("movies",showMovies);
			dispatcher.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MovieDao dao = new MovieDao();
//		System.out.println("view movies");
//		List <Movie>showMovies = new ArrayList<Movie>();
//		try {
//			showMovies= dao.getMovie();
//			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//			request.setAttribute("movies",showMovies);
//			dispatcher.forward(request,response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
