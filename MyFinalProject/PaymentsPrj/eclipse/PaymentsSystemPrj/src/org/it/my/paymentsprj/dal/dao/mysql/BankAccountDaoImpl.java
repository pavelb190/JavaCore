package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.BankAccountDao;
import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.User;

public class BankAccountDaoImpl extends AbstractDaoImpl implements
		BankAccountDao {

	@Override
	public BankAccount findById(long accountId) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM BankAccounts WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1,  accountId);
		
		ResultSet rs = stmt.executeQuery();
		
		BankAccount bankAccount = null;
		
		if (rs.next()) {
			
			bankAccount = new BankAccount();
			
			bankAccount.setId(rs.getLong("id"));
			
			bankAccount.setBalance(rs.getDouble("balance"));
			
			bankAccount.setUserId(rs.getLong("user_id"));
			
			bankAccount.setAvailable(rs.getBoolean("is_available"));
		}
		
		conn.close();
		
		return bankAccount;
	}

	@Override
	public List<BankAccount> findByUserId(long id) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM BankAccounts WHERE user_id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		List<BankAccount> userBankAccounts = new ArrayList<>();
		
		while (rs.next()) {
			
			BankAccount bankAccount = new BankAccount();
			
			bankAccount.setId(rs.getLong("id"));
			
			bankAccount.setUserId(rs.getLong("user_id"));
			
			bankAccount.setBalance(rs.getDouble("balance"));
			
			bankAccount.setAvailable(rs.getBoolean("is_available"));
			
			userBankAccounts.add(bankAccount);
		}
		
		conn.close();
		
		return userBankAccounts;
	}

	@Override
	public void add(BankAccount entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, BankAccount entity) throws SQLException {
		
		final String SQL_STR = "UPDATE BankAccounts " +
				"SET id = ?, user_id = ?, balance = ?, is_available = ? " +
					"WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, entity.getId());
		
		stmt.setLong(2, entity.getUserId());
		
		stmt.setDouble(3, entity.getBalance());
		
		stmt.setBoolean(4, entity.isAvailable());
		
		stmt.setLong(5, id);

		stmt.executeUpdate();
		
		conn.close();
	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BankAccount> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
