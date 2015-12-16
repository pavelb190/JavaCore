package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.dal.dto.UserDetails;

public interface UserDao extends Dao<User> {
	
	public User findByEmail(final String email) throws SQLException;
	
	public List<UserDetails> findAllWithDetails() throws SQLException;
}
