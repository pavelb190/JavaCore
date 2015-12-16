package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.CreditCard;

public interface CreditCardDao extends Dao<CreditCard> {
	
	public List<CreditCard> findByAccountId(final long id) throws SQLException;
}
