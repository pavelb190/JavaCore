package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.CreditCardDao;
import org.it.my.paymentsprj.dal.dto.BankAccount;
import org.it.my.paymentsprj.dal.dto.CreditCard;

public class CreditCardDaoImpl extends AbstractDaoImpl implements
		CreditCardDao {

	@Override
	public CreditCard findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditCard> findByAccountId(long id)
			throws SQLException {
		
		final String SQL_STR = "SELECT * FROM CreditCards WHERE account_id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		List<CreditCard> accountCreditCards = new ArrayList<>();
		
		while (rs.next()) {
			
			CreditCard creditCard = new CreditCard();
			
			creditCard.setId(rs.getLong("id"));
			
			creditCard.setAccountId(rs.getLong("account_id"));
			
			accountCreditCards.add(creditCard);
		}
		
		conn.close();
		
		return accountCreditCards;
	}

	@Override
	public void add(CreditCard entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, CreditCard entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CreditCard> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
