package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.it.my.paymentsprj.dal.dao.UserDao;
import org.it.my.paymentsprj.dal.entity.User;
import org.it.my.paymentsprj.domain.service.exception.PasswordMismatchException;
import org.it.my.paymentsprj.domain.service.exception.UserNotFoundException;

public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	@Override
	public void addUser(User newUser) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(long userId) throws SQLException {
		
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
		
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		
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
		
		return user;
	}

}
