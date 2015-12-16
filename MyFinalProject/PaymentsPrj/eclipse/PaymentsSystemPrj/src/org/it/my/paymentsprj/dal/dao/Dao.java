package org.it.my.paymentsprj.dal.dao;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dto.Entity;

public interface Dao<T extends Entity> {
	
	public void add(T entity) throws SQLException;
	public void update(final long id, T entity) throws SQLException;
	public void delete(final long id) throws SQLException;
	public T findById(final long id) throws SQLException;
	public List<T> findAll() throws SQLException;
}
