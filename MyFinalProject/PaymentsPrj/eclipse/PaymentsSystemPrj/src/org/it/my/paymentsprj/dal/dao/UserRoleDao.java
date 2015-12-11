package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;

public interface UserRoleDao {
	
	public String getRoleById(final int id) throws SQLException;
}
