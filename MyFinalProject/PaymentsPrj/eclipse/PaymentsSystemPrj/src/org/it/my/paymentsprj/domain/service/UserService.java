package org.it.my.paymentsprj.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.it.my.paymentsprj.dal.dao.UserDao;
import org.it.my.paymentsprj.dal.dao.UserRoleDao;
import org.it.my.paymentsprj.dal.dao.mysql.UserDaoImpl;
import org.it.my.paymentsprj.dal.dao.mysql.UserRoleDaoImpl;
import org.it.my.paymentsprj.dal.dto.User;
import org.it.my.paymentsprj.dal.dto.UserDetails;
import org.it.my.paymentsprj.dal.dto.UserRole;
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
			
			user = userDaoImpl.findById(id);
			
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
			
			user = userDaoImpl.findByEmail(email);
			
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
			
			userById = userDaoImpl.findById(user.getId());
			
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
		
		UserRole userRole = null;
		
		boolean hasPermissions = false;
		
		try {
			
			userRole = userRoleDaoImpl.findById(user.getRoleId());
			
			if (userRole != null && userRole.getRole().equals(roleRequired)) {
				
				hasPermissions = true;
				
			} else {
				
				throw new UserHasNoPermissionsException("User has no role " + roleRequired + "!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return hasPermissions;
	}
	
	public List<UserDetails> getUserDetailsForAll() {
		
		List<UserDetails> usersDetailsAll = null;
		
		try {
			
			usersDetailsAll = userDaoImpl.findAllWithDetails();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return usersDetailsAll;
	}
	
}
