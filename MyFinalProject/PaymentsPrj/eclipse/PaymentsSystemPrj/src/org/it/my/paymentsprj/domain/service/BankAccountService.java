package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.BankAccountDao;
import org.it.my.paymentsprj.dal.dao.mysql.BankAccountDaoImpl;
import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.domain.service.exception.AccountNotFoundException;
import org.it.my.paymentsprj.domain.service.exception.BankAccountNotFoundException;
import org.it.my.paymentsprj.domain.service.exception.NoAccountsFoundException;

public class BankAccountService {
	
	private BankAccountDao bankAccountDaoImpl;
	
	public BankAccountService() {
		
		this.bankAccountDaoImpl = new BankAccountDaoImpl();
	}
	
	public BankAccount getBankAccountById(final long id) throws AccountNotFoundException {
		
		BankAccount bankAccount = null;
		
		try {
			
			bankAccount = bankAccountDaoImpl.findById(id);
			
			if (bankAccount == null) {
				
				throw new AccountNotFoundException("BankAccount with id '" + id + "' not found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return bankAccount;
	}
	
	public List<BankAccount> getUserBankAccountsById(final long id) throws NoAccountsFoundException {
		
		List<BankAccount> userBankAccounts = null;
		
		try {
			
			userBankAccounts = bankAccountDaoImpl.findByUserId(id);
			
			if (userBankAccounts == null) {
				
				throw new NoAccountsFoundException("No BankAccounts found for User '" + id + "'!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return userBankAccounts;
	}
	
	public void lockBankAccountById(final long id) throws BankAccountNotFoundException {
		
		BankAccount bankAccount = null;
		
		try {
			
			bankAccount = bankAccountDaoImpl.findById(id);
			
			if (bankAccount != null) {
				
				bankAccount.setAvailable(false);
				
				bankAccountDaoImpl.update(id, bankAccount);
				
			} else {
				
				throw new BankAccountNotFoundException("BankAccount with id '" + id + "' not found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
	}
	
	public void unlockBankAccountById(final long id) throws BankAccountNotFoundException {
		
		BankAccount bankAccount = null;
		
		try {
			
			bankAccount = bankAccountDaoImpl.findById(id);
			
			if (bankAccount != null) {
				
				bankAccount.setAvailable(true);
				
				bankAccountDaoImpl.update(id, bankAccount);
				
			} else {
				
				throw new BankAccountNotFoundException("BankAccount with id '" + id + "' not found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
	}
}
