package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;

import org.it.my.paymentsprj.dal.entity.Transaction;

public interface TransactionDao {
	
	public void addTransaction(Transaction transaction) throws SQLException;
}
