package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.User;

public interface BankAccountDao extends Dao<BankAccount> {
	
	public List<BankAccount> findByUserId(final long id) throws SQLException;
}
