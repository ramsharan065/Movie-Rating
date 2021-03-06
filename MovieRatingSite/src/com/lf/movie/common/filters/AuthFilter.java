package com.lf.movie.common.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lf.movie.auth.dto.User;
import com.lf.movie.auth.models.UserDao;

/**
 * Servlet Filter implementation class AuthUserFilter
 */
public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session;
		session = req.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			// TODO 'remember me part should be placed here'
			Cookie cookies[] = req.getCookies();
			if (cookies == null) {
				chain.doFilter(request, response);
				return;
			}
			String token = null;
			for (Cookie c : cookies) {
				System.out.println(c.getName()+" cookie name ");
				if (c.getName().equals("token")) {
					token = c.getValue();
					break;
				}
			}
			if (token != null) {
				UserDao dao = new UserDao();
				User tokenUser = dao.getUserFromToken(token);
				if (tokenUser != null) {
					session = req.getSession();
					session.setAttribute("user", tokenUser);
				} else {
					chain.doFilter(request, response);
					return;
				}
			} else {
				chain.doFilter(request, response);
				return;
			}
		}
		User user = (User) session.getAttribute("user");
		if (user.getRole().equals("admin")) {
			// TODO it should be redirect to admin dashboard
			System.out.println("redirecting to admin dashboard");
			resp.sendRedirect(req.getContextPath() + "/app/home");
		} else {
			System.out.println("redirecting to app home");
			resp.sendRedirect(req.getContextPath() + "/app/home");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
