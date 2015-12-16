package org.it.my.paymentsprj.domain.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.CreditCard;
import org.it.my.paymentsprj.dal.dto.Transaction;
import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.dal.dto.UserDetails;
import org.it.my.paymentsprj.dal.dto.UserRoles;
import org.it.my.paymentsprj.domain.service.BankAccountService;
import org.it.my.paymentsprj.domain.service.CreditCardService;
import org.it.my.paymentsprj.domain.service.TransactionService;
import org.it.my.paymentsprj.domain.service.UserService;
import org.it.my.paymentsprj.domain.service.exception.AccountNotFoundException;
import org.it.my.paymentsprj.domain.service.exception.NoAccountsFoundException;
import org.it.my.paymentsprj.domain.service.exception.NoCreditCardsFoundException;
import org.it.my.paymentsprj.domain.service.exception.UserHasNoPermissionsException;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({ "/", "/index", "/main" })
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String SESSION_ID_HAS_ROLE_LABEL;
	
	private static final UserService userService = new UserService();
	
	private static final BankAccountService bankAccountService = new BankAccountService();
	
	private static final CreditCardService creditCardService = new CreditCardService();
	
	private static final TransactionService transactionService = new TransactionService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
    	
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		SESSION_ID_HAS_ROLE_LABEL = getServletContext().getInitParameter("SESSION_ID_HAS_ROLE_LABEL");
		
		UserRoles userRole = (UserRoles) session.getAttribute(SESSION_ID_HAS_ROLE_LABEL);
		
		switch (userRole) {
			
			case ADMIN:
				
				userRoleIsAdmin(request, response);
				
				break;
			
			case CLIENT:
				
				userRoleIsClient(request, response);
				
				break;
		}
		
		request.setAttribute("userRole", session.getAttribute(SESSION_ID_HAS_ROLE_LABEL));
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void userRoleIsAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<UserDetails> usersDetailsAll = userService.getUserDetailsForAll();
		
		req.setAttribute("usersDetailsAll", usersDetailsAll);
		
		final String userid = req.getParameter("userid");
		
		if (userid != null) {
			
			UserDetails userDetails = null;
			
			for(UserDetails uDetails : usersDetailsAll) {
				
				if (Long.parseLong(userid) == uDetails.getId()) {
					
					userDetails = uDetails;
					
					break;
				}
			}
			
			List<BankAccount> userBankAccounts = null;
			
			try {
				
				userBankAccounts = bankAccountService.getUserBankAccountsById(Long.parseLong(userid));
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
				
				// ...
				
			} catch (NoAccountsFoundException e) {
				
				e.printStackTrace();
				
				// ...
				
			}
			
			req.setAttribute("userSelected", true);
			
			req.setAttribute("userDetails", userDetails);
			
			req.setAttribute("userBankAccounts", userBankAccounts);
			
		} else {
			
			req.setAttribute("userSelected", false);
			
			req.removeAttribute("userDetails");
		}
	}
	
	private void userRoleIsClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		final String accnum = req.getParameter("accnum");
		
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user");
		
		List<BankAccount> userBankAccounts = null;
			
		try {
			
			userBankAccounts = bankAccountService.getUserBankAccountsById(user.getId());
			
			req.setAttribute("userBankAccounts", userBankAccounts);
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			
			// ...
			
		} catch (NoAccountsFoundException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		if (accnum != null) {
			
			req.setAttribute("accountSelected", true);
			
			req.setAttribute("accountNum", accnum);
			
			List<CreditCard> accountCreditCards = null;
			
			try {
				
				accountCreditCards = creditCardService.getCreditCardsForAccountById(Long.parseLong(accnum));
				
				req.setAttribute("accountCreditCards", accountCreditCards);
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
				
				// ...
				
			} catch (NoCreditCardsFoundException e) {
				
				e.printStackTrace();
				
				// ...
			}
			
			List<Transaction> accountTransactions = null;
			
			accountTransactions = transactionService.getTransactionHistoryForAccountById(Long.parseLong(accnum));
			
			req.setAttribute("accountTransactions", accountTransactions);
			
		} else {
			
			req.setAttribute("accountSelected", false);
			
			req.removeAttribute("accountNum");
		}
		
		req.setAttribute("error", session.getAttribute("error"));
		
		req.setAttribute("cause", session.getAttribute("cause"));
		
		session.removeAttribute("error");
		
		session.removeAttribute("cause");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
