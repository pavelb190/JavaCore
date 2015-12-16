package org.it.my.paymentsprj.domain.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.domain.service.UserService;
import org.it.my.paymentsprj.domain.service.exception.UserHasNoPermissionsException;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession httpSession = httpRequest.getSession();
		
		User user = (User) httpSession.getAttribute("user");
		
		String reqUri = httpRequest.getRequestURI();
		
		String contextPath = httpRequest.getContextPath();
		
		final String resource = reqUri.replace(contextPath, "");
		
		if (user == null && !"/login".equals(resource) && !"/login.jsp".equals(resource)) {
			
			httpResponse.sendRedirect("login.jsp");
			
			return ;
			
		} else if (user != null && "/login.jsp".equals(resource)) {
			
			httpResponse.sendRedirect("index");
			
			return ;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
