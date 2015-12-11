package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;

import org.it.my.paymentsprj.dal.entity.User;

public interface UserDao {
	
	public void addUser(final User newUser) throws SQLException;
	public User getUserById(final long userId) throws SQLException;
	public User getUserByEmail(final String email) throws SQLException;
}
