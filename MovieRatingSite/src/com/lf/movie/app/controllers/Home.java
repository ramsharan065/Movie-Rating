package com.lf.movie.app.controllers;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lf.movie.app.dto.Movie;
import com.lf.movie.app.models.MovieDao;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("may be "+request.getRequestURL());
		//String purl = (String)request.getAttribute("javax.servlet.forward.request_uri");
		String ss = request.getHeader("Referer");
		if(ss!=null){
		int length = (request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()).length();
		System.out.println(request.getHeader("Referer").substring(length)+ " is the previous link");
		}
		MovieDao dao = new MovieDao();
		ArrayList<Movie> latestMovies = dao.getLatestMovies(10);
		//ArrayList<Movie> rankMovies = dao.getRankMovies(10);
		request.setAttribute("latestMovies", latestMovies);

//		request.setAttribute("rankMovies", rankMovies);
		request.getRequestDispatcher("/pages/app/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
