package com.lf.movie.auth.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lf.movie.auth.dto.User;
import com.lf.movie.auth.models.UserDao;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null){
			User user = (User)session.getAttribute("user");
			if(user!=null && user.getToken()!=null){
				Cookie cookies[] = request.getCookies();
				if(cookies!=null){
					for(Cookie c : cookies){
						if(c.getName().equals("token")){
							c.setMaxAge(0);
							break;
						}
					}
				}
				UserDao dao = new UserDao();
				dao.removeToken(user);
			}
			session.invalidate();
		}
		response.sendRedirect(request.getContextPath()+"/app/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
