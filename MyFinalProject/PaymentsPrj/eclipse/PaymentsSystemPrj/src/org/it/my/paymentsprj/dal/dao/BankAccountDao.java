package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.entity.BankAccount;
import org.it.my.paymentsprj.dal.entity.User;

public interface BankAccountDao {
	
	public void createAccountForUser(BankAccount account, User user) throws SQLException;
	public BankAccount getAccountById(final long accountId) throws SQLException;
	public List<BankAccount> getAccountsForUser(User user) throws SQLException;
	public void accountUpdate(BankAccount account) throws SQLException;
	public void accountLock(BankAccount account) throws SQLException;
	public void accountUnlock(BankAccount account) throws SQLException;
	public boolean accountIsAvailable(BankAccount account) throws SQLException;
}
