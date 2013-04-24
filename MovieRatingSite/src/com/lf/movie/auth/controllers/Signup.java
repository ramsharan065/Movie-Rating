package com.lf.movie.auth.controllers;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lf.movie.auth.models.UserDao;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//show signup form
		request.getRequestDispatcher("/pages/auth/signup_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		request.setAttribute("name", name);
		request.setAttribute("username", username);
		//check for empty : it is done in check for format
		//check for format of name and username
		Boolean bname=Pattern.matches("^[a-zA-Z ]{1,50}$", name);
		Boolean busername=Pattern.matches("^[\\w]{1,50}$", username);
		Boolean bpassword=Pattern.matches("^.{6,50}$", password);
		System.out.println(bname.toString()+busername.toString()+bpassword.toString());
		if(!(bname && busername && bpassword)){
			request.setAttribute("error", "invalid_input");
			request.getRequestDispatcher("/pages/auth/signup_form.jsp").forward(request, response);
			return;
		}
		if(password.equals(rePassword)){
			UserDao dao = new UserDao();
			if(dao.addUser(name, username, password)==true){
				//TODO show signup successfull page and give link to login page or home
				System.out.println("signup successful");
			}
			else{
				System.out.println("username already exists");
				request.setAttribute("error", "username_already_exists");
				request.getRequestDispatcher("/pages/auth/signup_form.jsp").forward(request, response);
				return;
			}
		}else{
			System.out.println("password and rePassword donot match");
			request.setAttribute("error", "invalid_input");
			request.getRequestDispatcher("/pages/auth/signup_form.jsp").forward(request, response);
			return;
		}
	}

}
