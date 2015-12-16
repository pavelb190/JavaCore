package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.TransactionDao;
import org.it.my.paymentsprj.dal.dao.mysql.TransactionDaoImpl;
import org.it.my.paymentsprj.dal.dto.Transaction;
import org.it.my.paymentsprj.domain.service.exception.UnableToCompleteTransactionException;

public class TransactionService {
	
	private TransactionDao transactionDaoImpl;
	
	public TransactionService() {
		
		this.transactionDaoImpl = new TransactionDaoImpl();
	}
	
	public void addTransaction(Transaction transaction) throws UnableToCompleteTransactionException {
		
		try {
			
			transactionDaoImpl.add(transaction);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ... 
			
			throw new UnableToCompleteTransactionException("Current Transaction failed!", e);
		}
	}
	
	public List<Transaction> getTransactionHistoryForAccountById(final long id) {
		
		List<Transaction> transactionHistory = null;
		
		try {
			
			transactionHistory = transactionDaoImpl.findByAccountId(id);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return transactionHistory;
	}
}
