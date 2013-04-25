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
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserFilter() {
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
					System.out.println("Unauthorized request");
					// TODO instead of redirecting to app home, it should be redirected
					// to unauthorized page(you cannot access this page)
					resp.sendRedirect(req.getContextPath() + "/app/home");
					return;
				}
			} else {
				System.out.println("Unauthorized request");
				// TODO instead of redirecting to app home, it should be redirected
				// to unauthorized page(you cannot access this page)
				resp.sendRedirect(req.getContextPath() + "/app/home");
				return;
			}
		}
		User user = (User) session.getAttribute("user");
		if (user.getRole().equals("admin") || user.getRole().equals("user")) {
			chain.doFilter(request, response);
		} else {
			// TODO instead of redirecting to app home, it should be redirected
			// to unauthorized page(you cannot access this page)
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
