package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.entity.BankAccount;
import org.it.my.paymentsprj.dal.entity.CreditCard;

public interface CreditCardDao {
	
	public void addCreditCard(final CreditCard creditCard) throws SQLException;
	public CreditCard getCreditCardById(final long creditCardId) throws SQLException;
	public List<CreditCard> getCreditCardsForAccount(final BankAccount account) throws SQLException;

	// ...
}
