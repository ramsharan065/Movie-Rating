package com.lf.movie.auth.controllers;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lf.movie.auth.dto.User;
import com.lf.movie.auth.models.UserDao;

/**
 * Servlet implementation class Login
 */
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
		request.getRequestDispatcher("/pages/auth/login_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//validate user
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		//check for empty fields
		if(username.isEmpty() || password.isEmpty()){
			request.setAttribute("username", username);
			request.setAttribute("error", "empty");
			request.getRequestDispatcher("/pages/auth/login_form.jsp").forward(request, response);
			return;
		}
		try{
			UserDao dao = new UserDao();
			User user = dao.getUser(username, password);
			if(user==null){
				request.setAttribute("username", username);
				request.setAttribute("error", "not_matched");
				request.getRequestDispatcher("/pages/auth/login_form.jsp").forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//remember me
				if(remember!=null || remember=="true"){
					String token = UUID.randomUUID().toString();
					Cookie cookie = new Cookie("token", token);
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
					dao.setToken(user,token);
				}
				if(user.getRole().equals("user")){
					response.sendRedirect(request.getContextPath()+"/app/home");
				}else if(user.getRole().equals("admin")){
					//TODO it should be redirect to admin dashboard
					System.out.println("redirecting to admin dashboard");
					response.sendRedirect(request.getContextPath()+"/app/home");
				}
			}
		}catch(Exception e){
			response.sendRedirect(request.getContextPath()+"/app/home");
			e.printStackTrace();
		}
	}
}
