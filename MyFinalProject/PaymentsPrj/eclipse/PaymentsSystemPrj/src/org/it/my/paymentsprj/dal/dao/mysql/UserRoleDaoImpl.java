package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.UserRoleDao;
import org.it.my.paymentsprj.dal.dto.Entity;
import org.it.my.paymentsprj.dal.dto.UserRole;

public class UserRoleDaoImpl extends AbstractDaoImpl implements UserRoleDao {

	@Override
	public void add(UserRole entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, UserRole entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserRole findById(long id) throws SQLException {
		
		final String SQL_STR = "SELECT * FROM User_roles WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(SQL_STR);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		UserRole userRole = null;
		
		if (rs.next()) {
			
			userRole = new UserRole();
			
			userRole.setId(rs.getLong("id"));
			
			userRole.setRole(rs.getString("role"));
		}
		
		conn.close();
		
		return userRole;
	}

	@Override
	public List<UserRole> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
