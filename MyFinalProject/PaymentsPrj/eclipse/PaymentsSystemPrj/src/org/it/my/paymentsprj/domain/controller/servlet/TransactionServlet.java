package org.it.my.paymentsprj.domain.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.it.my.paymentsprj.dal.dto.Transaction;
import org.it.my.paymentsprj.domain.service.TransactionService;
import org.it.my.paymentsprj.domain.service.exception.UnableToCompleteTransactionException;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/transaction/*")
public class TransactionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final TransactionService transactionService = new TransactionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String pathInfo = request.getPathInfo();
		
		final String uri = (pathInfo != null ? pathInfo : "/"); 
		
		final String action = uri.replace("/", "");
		
		switch (action) {
			
			case "add":
				
				Transaction tran = new Transaction();
				
				final String accnum = request.getParameter("accnum");
				
				final String moneyAmount = request.getParameter("money-amount");
				
				final String operationType = request.getParameter("operation-type");
				
				boolean isPayment = (operationType.equals("is-payment") ? true : false);
				
				final String description = request.getParameter("description");
				
				tran.setAccountId(Long.parseLong(accnum));
				
				tran.setMoneyAmount(Double.parseDouble(moneyAmount));
				
				tran.setPayment(isPayment);
				
				tran.setDescription(description);
				
				addTransaction(request, tran, response);
				
				response.sendRedirect("../index?accnum=" + accnum);
				
				break;
		
			// ...
			
			default:
				
				// ...
		}
	}
	
	private void addTransaction(HttpServletRequest request, Transaction transaction, HttpServletResponse response) {
		
		try {
			
			transactionService.addTransaction(transaction);
			
		} catch (UnableToCompleteTransactionException e) {
			
			e.printStackTrace();
			
			request.getSession().setAttribute("error", e.getMessage());
			
			request.getSession().setAttribute("cause", e.getCause().getMessage());
		}
	}
}
