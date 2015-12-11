package org.it.my.paymentsprj.dal.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
	
	private static final String DB_NAME = "DB_Payments";
	
	private static final DataSource dataSource = getDataSource();
	
	private static DataSource getDataSource() {
		
		Context initCtxt = null;
		
		DataSource dataSource = null;
		
		try {
			
			initCtxt = new InitialContext();
			
			dataSource = (DataSource) initCtxt.lookup("java:/comp/env/jdbc/" + DB_NAME); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			
			conn = dataSource.getConnection();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return conn;
	}
}
