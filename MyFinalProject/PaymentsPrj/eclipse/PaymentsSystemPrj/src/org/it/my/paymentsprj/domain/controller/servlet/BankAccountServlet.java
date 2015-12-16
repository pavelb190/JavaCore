package org.it.my.paymentsprj.domain.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.domain.service.BankAccountService;
import org.it.my.paymentsprj.domain.service.exception.BankAccountNotFoundException;

/**
 * Servlet implementation class BankAccountServlet
 */
@WebServlet("/bank-account/*")
public class BankAccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final BankAccountService bankAccountService = new BankAccountService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String pathInfo = request.getPathInfo();
		
		final String uri = (pathInfo != null ? pathInfo : "/"); 
		
		final String action = uri.replace("/", "");
		
		String accnum = request.getParameter("accnum");
		
		final long accountId = Long.parseLong(accnum);
		
		switch (action) {
		
			case "enable":
				
				unlockBankAccountById(accountId);
				
				response.sendRedirect("../index?userid=" + request.getParameter("userid"));
				
				break;
		
			case "disable":
				
				lockBankAccountById(accountId);
				
				response.sendRedirect("../index");
				
				break;
				
			default:
				
				// ...
		}
	}
	
	private void lockBankAccountById(final long accountId) {
		
		try {
			
			bankAccountService.lockBankAccountById(accountId);
			
		} catch (BankAccountNotFoundException e) {
			
			e.printStackTrace();
			
			// ...
		}
	}
	
	private void unlockBankAccountById(final long accountId) {
		
		try {
			
			bankAccountService.unlockBankAccountById(accountId);
			
		} catch (BankAccountNotFoundException e) {
			
			e.printStackTrace();
			
			// ...
		}
	}
}
