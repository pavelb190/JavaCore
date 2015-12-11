package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;

import org.it.my.paymentsprj.dal.dao.UserDao;
import org.it.my.paymentsprj.dal.dao.UserRoleDao;
import org.it.my.paymentsprj.dal.dao.mysql.UserDaoImpl;
import org.it.my.paymentsprj.dal.dao.mysql.UserRoleDaoImpl;
import org.it.my.paymentsprj.dal.entity.User;
import org.it.my.paymentsprj.domain.service.exception.PasswordMismatchException;
import org.it.my.paymentsprj.domain.service.exception.UserHasNoPermissionsException;
import org.it.my.paymentsprj.domain.service.exception.UserNotFoundException;

public class UserService {
	
	private UserRoleDao userRoleDaoImpl;
	private UserDao userDaoImpl;
	
	public UserService() {
		
		this.userRoleDaoImpl = new UserRoleDaoImpl();
		this.userDaoImpl = new UserDaoImpl();
	}
	
	public User getUser(long id) throws UserNotFoundException {
		
		User user = null;
		
		try {
			
			user = userDaoImpl.getUserById(id);
			
			if (user == null) {
				
				throw new UserNotFoundException("User with id '" + id + "' not found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return user;
	}
	
	public User getUser(final String email) throws UserNotFoundException {
		
		User user = null;
		
		try {
			
			user = userDaoImpl.getUserByEmail(email);
			
			if (user == null) {
				
				throw new UserNotFoundException("User with email '" + email + "' not found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return user;
	}
	
	public boolean checkUser(User user) throws UserNotFoundException, PasswordMismatchException {
		
		User userById = null;
		
		boolean userMatched = false;
		
		try {
			
			userById = userDaoImpl.getUserById(user.getId());
			
			if (userById != null) {
				
				if (userById.getPassword().equals(user.getPassword())) {
					
					userMatched = true;
					
				} else {
					
					throw new PasswordMismatchException("Passwords mismatch!"); 
				}
				
			} else {
				
				throw new UserNotFoundException("Such a User is not Found!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return userMatched;
	} 
	
	public boolean hasRole(User user, final String roleRequired) throws UserHasNoPermissionsException {
		
		String role = null;
		
		boolean hasPermissions = false;
		
		try {
			
			role = userRoleDaoImpl.getRoleById(user.getRoleId());
			
			if (role != null && role.equals(roleRequired)) {
				
				hasPermissions = true;
				
			} else {
				
				throw new UserHasNoPermissionsException("User has no role " + role + "!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return hasPermissions;
	}
}
