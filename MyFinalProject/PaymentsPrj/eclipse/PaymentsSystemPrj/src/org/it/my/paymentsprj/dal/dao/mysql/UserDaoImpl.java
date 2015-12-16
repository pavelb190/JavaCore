package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.UserDao;
import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.dal.dto.UserDetails;
import org.it.my.paymentsprj.domain.service.exception.PasswordMismatchException;
import org.it.my.paymentsprj.domain.service.exception.UserNotFoundException;

public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	@Override
	public void add(User newUser) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(long userId) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM Users WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, userId);
		
		ResultSet rs = stmt.executeQuery();
		
		User user = null;
		
		if (rs.next()) {
			
			user = new User();
			
			user.setId(rs.getLong("id"));
			
			user.setFirstName(rs.getString("first_name"));
			
			user.setLastName(rs.getString("last_name"));
			
			user.setEmail(rs.getString("email"));
			
			user.setPassword(rs.getString("password"));
			
			user.setRoleId(rs.getInt("role_id"));
		}
		
		conn.close();
		
		return user;
	}

	@Override
	public User findByEmail(String email) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM Users WHERE email = ?";

		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setString(1, email);
		
		ResultSet rs = stmt.executeQuery();
		
		User user = null;
		
		if (rs.next()) {
			
			user = new User();
			
			user.setId(rs.getLong("id"));
			
			user.setFirstName(rs.getString("first_name"));
			
			user.setLastName(rs.getString("last_name"));
			
			user.setEmail(rs.getString("email"));
			
			user.setPassword(rs.getString("password"));
			
			user.setRoleId(rs.getInt("role_id"));
		}
		
		conn.close();
		
		return user;
	}

	@Override
	public void update(long id, User entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() throws SQLException {
		
		// ...
		
		return null;
	}

	@Override
	public List<UserDetails> findAllWithDetails() throws SQLException {
		
		final String SQL_STR = "SELECT u.id, u.first_name, u.last_name, u.email, " +
					"(SELECT count(*) FROM BankAccounts WHERE user_id = u.id AND is_available = false) as acc_blocked_count, " +
					"(SELECT count(*) FROM BankAccounts WHERE user_id = u.id AND is_available = true) as acc_available_count " +
				"FROM Users u, BankAccounts ba, User_roles ur " +
				"WHERE u.id = ba.user_id AND u.role_id = ur.id AND ur.role = 'User'";
		
		Connection conn = this.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(SQL_STR);
		
		List<UserDetails> usersDetailsAll = new ArrayList<>(); 
		
		while (rs.next()) {
			
			UserDetails userDetails = new UserDetails();
			
			userDetails.setId(rs.getLong("id"));
			
			userDetails.setFirstName(rs.getString("first_name"));
			
			userDetails.setLastName(rs.getString("last_name"));
			
			userDetails.setEmail(rs.getString("email"));
			
			userDetails.setAccountBlockedCount(rs.getInt("acc_blocked_count"));
			
			userDetails.setAccountAvailableCount(rs.getInt("acc_available_count"));
			
			usersDetailsAll.add(userDetails);
		}
		
		conn.close();
		
		return usersDetailsAll;
	}

}
