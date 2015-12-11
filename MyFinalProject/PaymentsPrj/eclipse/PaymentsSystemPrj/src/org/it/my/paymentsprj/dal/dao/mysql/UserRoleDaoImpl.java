package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.it.my.paymentsprj.dal.dao.UserRoleDao;

public class UserRoleDaoImpl extends AbstractDaoImpl implements UserRoleDao {

	@Override
	public String getRoleById(int id) throws SQLException {
		
		final String SQL_STR = "SELECT role FROM User_roles WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		String role = null;
		
		if (rs.next()) {
			
			role = rs.getString("role");
		}
		
		return role;
	}
	
}
