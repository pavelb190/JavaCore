package org.it.my.paymentsprj.domain.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.dal.dto.UserRoles;
import org.it.my.paymentsprj.domain.service.UserService;
import org.it.my.paymentsprj.domain.service.exception.PasswordMismatchException;
import org.it.my.paymentsprj.domain.service.exception.UserHasNoPermissionsException;
import org.it.my.paymentsprj.domain.service.exception.UserNotFoundException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id != null) {
			
			User user = new User();
			
			long userId = Long.parseLong(id);
			
			user.setId(userId);
			
			String password = request.getParameter("passwd");
			
			user.setPassword(password);
			
			try {
				
				if (userService.checkUser(user)) {
					
					HttpSession session = request.getSession(true);
					
					User userById = userService.getUser(userId);
					
					session.setAttribute("user", userById);
					
					final String SESSION_ID_HAS_ROLE_LABEL = getServletContext().getInitParameter("SESSION_ID_HAS_ROLE_LABEL");
					
					session.setAttribute(SESSION_ID_HAS_ROLE_LABEL, getUserRole(userById));
					
					response.sendRedirect("index");
					
				} else {
					
					response.sendRedirect("login.jsp");
				}
				
			} catch (UserNotFoundException | PasswordMismatchException e) {
				
				e.printStackTrace();
				
				request.setAttribute("message", e.getMessage());
				
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} else {
			
			response.sendRedirect("login.jsp");
		}
		
	}

	private UserRoles getUserRole(User user) {
		
		UserRoles userRole = null;
		
		try {
			
			if (userService.hasRole(user, "Admin")) {
				
				userRole = UserRoles.ADMIN;
			}
			
		} catch (UserHasNoPermissionsException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		try {
			
			if (userService.hasRole(user, "User")) {
				
				userRole = UserRoles.CLIENT;
			}
			
		} catch (UserHasNoPermissionsException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return userRole;
	}
}
