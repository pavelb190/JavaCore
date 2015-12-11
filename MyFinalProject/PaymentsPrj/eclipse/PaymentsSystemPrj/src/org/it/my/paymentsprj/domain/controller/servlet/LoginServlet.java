package org.it.my.paymentsprj.domain.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.it.my.paymentsprj.dal.entity.User;
import org.it.my.paymentsprj.domain.service.UserService;
import org.it.my.paymentsprj.domain.service.exception.PasswordMismatchException;
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
					
					session.setAttribute("user", userService.getUser(userId));
					
					response.sendRedirect("index.jsp");
					
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

}
