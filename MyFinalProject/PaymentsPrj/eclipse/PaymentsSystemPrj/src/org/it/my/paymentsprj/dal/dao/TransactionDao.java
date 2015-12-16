package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dto.Transaction;

public interface TransactionDao extends Dao<Transaction> {
	
	public List<Transaction> findByAccountId(final long id) throws SQLException;
}
