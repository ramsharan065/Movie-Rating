package com.lf.movie.auth.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lf.movie.auth.models.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//show login page
		String s = request.getServletContext().getContextPath();
		System.out.println("servletcontext.contextpath   "+s);
		System.out.println("request.contextpath     "+request.getContextPath());
		request.getRequestDispatcher("/pages/auth/login_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//validate user
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String s = request.getServletContext().getContextPath();
		System.out.println("servletcontext.contextpath   "+s);
		System.out.println("request.contextpath     "+request.getContextPath());
		try{
			UserDao dao = new UserDao();
			Boolean isValidUser = dao.isValidUser(username, password);
			if(isValidUser){
				HttpSession session = request.getSession();
				session.setAttribute("user", new Integer(dao.getUserId()));
				response.sendRedirect(request.getContextPath()+"/app/home");
				//System.out.println("login in");
			}
			else{
				response.sendRedirect(request.getContextPath()+"/auth/login");
			}
		}catch(Exception e){
			response.sendRedirect("login");
			e.printStackTrace();
		}
		
	}

}
