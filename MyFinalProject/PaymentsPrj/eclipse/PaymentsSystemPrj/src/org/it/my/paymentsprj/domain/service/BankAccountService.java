package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.BankAccountDao;
import org.it.my.paymentsprj.dal.dao.mysql.BankAccountDaoImpl;
import org.it.my.paymentsprj.dal.entity.BankAccount;
import org.it.my.paymentsprj.dal.entity.User;
import org.it.my.paymentsprj.domain.service.exception.NoAccountsFoundException;

public class BankAccountService {
	
	private BankAccountDao bankAccountDaoImpl;
	
	public BankAccountService() {
		
		this.bankAccountDaoImpl = new BankAccountDaoImpl();
	}
	
	public List<BankAccount> getUserBankAccounts(User user) throws NoAccountsFoundException {
		
		List<BankAccount> userBankAccounts = null;
		
		try {
			
			userBankAccounts = bankAccountDaoImpl.getAccountsForUser(user);
			
			if (userBankAccounts == null) {
				
				throw new NoAccountsFoundException("No BankAccounts found for User '" + user.getId() + "'!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return userBankAccounts;
	}
}
