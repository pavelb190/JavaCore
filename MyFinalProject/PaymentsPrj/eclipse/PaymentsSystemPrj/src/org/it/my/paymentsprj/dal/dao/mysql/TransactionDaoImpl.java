package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.TransactionDao;
import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.Transaction;
import org.it.my.paymentsprj.domain.service.exception.InsufficientFundsInAccountException;

public class TransactionDaoImpl extends AbstractDaoImpl implements
		TransactionDao {

	@Override
	public void add(Transaction entity) throws SQLException {
		
		final String ADD_TRANSACTION_SQL_STR = "INSERT INTO Transactions " +
				"(account_id, money_amount, is_payment, description) " +
					"VALUES (?, ?, ?, ?)";
		
		final String UPDATE_BANK_ACCOUNT_SQL_STR = "UPDATE BankAccounts " +
				"SET balance = balance + ? WHERE id = ?";
		
		final String GET_BALANCE_BANK_ACCOUNT_SQL_STR = "SELECT balance FROM BankAccounts WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		conn.setAutoCommit(false);
		
		PreparedStatement addTransactionStmt 	= null;
		PreparedStatement updateBankAccountStmt = null;
		PreparedStatement getCurrentBalanceStmt = null;
		
		try {
			
			addTransactionStmt = conn.prepareStatement(ADD_TRANSACTION_SQL_STR);
			updateBankAccountStmt = conn.prepareStatement(UPDATE_BANK_ACCOUNT_SQL_STR);
			getCurrentBalanceStmt = conn.prepareStatement(GET_BALANCE_BANK_ACCOUNT_SQL_STR);
			
			addTransactionStmt.setLong(1, entity.getAccountId());
			
			addTransactionStmt.setDouble(2, entity.getMoneyAmount());
			addTransactionStmt.setBoolean(3, entity.isPayment());
			
			addTransactionStmt.setString(4, entity.getDescription());

			addTransactionStmt.executeUpdate();
			
			updateBankAccountStmt.setDouble(1, entity.isPayment() ? -entity.getMoneyAmount() : +entity.getMoneyAmount());
			
			updateBankAccountStmt.setLong(2, entity.getAccountId());
			
			updateBankAccountStmt.executeUpdate();
			
			getCurrentBalanceStmt.setLong(1, entity.getAccountId());
			
			ResultSet rs = getCurrentBalanceStmt.executeQuery();
			
			if (rs.next() && rs.getDouble("balance") >= 0) {
				
				conn.commit();
				
			} else {
				
				throw new InsufficientFundsInAccountException("You have no money enough!");
			}
			
		} catch (SQLException | InsufficientFundsInAccountException e) {
			
			e.printStackTrace();
			
			conn.rollback();
			
			// ...
			
			throw new SQLException(e);
			
		} finally {
			
			conn.setAutoCommit(true);
			
			conn.close();
		}
	}

	@Override
	public void update(long id, Transaction entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Transaction findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByAccountId(long id) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM Transactions WHERE account_id = ? ORDER BY committed_at";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		List<Transaction> accountTransactions = new ArrayList<>();
		
		while (rs.next()) {
			
			Transaction tran = new Transaction();
			
			tran.setId(rs.getLong("id"));
			
			tran.setAccountId(rs.getLong("account_id"));
			
			tran.setMoneyAmount(rs.getDouble("money_amount"));
			
			tran.setPayment(rs.getBoolean("is_payment"));
			
			tran.setDescription(rs.getString("description"));
			
			tran.setCommittedAt(rs.getTimestamp("committed_at"));
			
			accountTransactions.add(tran);
		}
		
		conn.close();
		
		return accountTransactions;
	}

}
