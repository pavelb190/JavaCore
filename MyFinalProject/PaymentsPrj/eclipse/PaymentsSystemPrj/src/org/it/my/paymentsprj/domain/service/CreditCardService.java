package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.CreditCardDao;
import org.it.my.paymentsprj.dal.dao.mysql.CreditCardDaoImpl;
import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.CreditCard;
import org.it.my.paymentsprj.domain.service.exception.NoCreditCardsFoundException;

public class CreditCardService {
	
	private CreditCardDao creditCardDaoImpl;
	
	public CreditCardService() {
		
		this.creditCardDaoImpl = new CreditCardDaoImpl();
	}
	
	public List<CreditCard> getCreditCardsForAccountById(final long id) throws NoCreditCardsFoundException {
		
		List<CreditCard> accountCreditCards = null;
		
		try {
			
			accountCreditCards = creditCardDaoImpl.findByAccountId(id);
			
			if (accountCreditCards == null) {
				
				throw new NoCreditCardsFoundException("No CreditCards Found for this BankAccount!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			//
		}
		
		return accountCreditCards;
	}
}
