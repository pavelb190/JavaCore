package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.BankAccountDao;
import org.it.my.paymentsprj.dal.entity.BankAccount;
import org.it.my.paymentsprj.dal.entity.User;

public class BankAccountDaoImpl extends AbstractDaoImpl implements
		BankAccountDao {

	@Override
	public void createAccountForUser(BankAccount account, User user)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public BankAccount getAccountById(long accountId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> getAccountsForUser(User user) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM BankAccounts WHERE user_id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1,  user.getId());
		
		ResultSet rs = stmt.executeQuery();
		
		List<BankAccount> userBankAccounts = new ArrayList();
		
		while (rs.next()) {
			
			BankAccount bankAccount = new BankAccount();
			
			bankAccount.setId(rs.getLong("id"));
			
			bankAccount.setUserId(rs.getLong("user_id"));
			
			bankAccount.setBalance(rs.getDouble("balance"));
			
			bankAccount.isAvailable(rs.getBoolean("is_available"));
			
			userBankAccounts.add(bankAccount);
		}
		
		return userBankAccounts;
	}

	@Override
	public void accountUpdate(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountLock(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountUnlock(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean accountIsAvailable(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
