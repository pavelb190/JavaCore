package org.it.my.paymentsprj.dal.entity;

public class User extends Entity {
	
	private String firstName;
	private String lastName;
	
	private String email;

	private String password;
	
	private int roleId;
	
	public User() {}
	
	public String getFirstName() {

		return this.firstName;
	}

	public void setFirstName(final String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return this.lastName;
	}

	public void setLastName(final String lastName) {

		this.lastName = lastName;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setEmail(final String email) {
		
		this.email = email;
	}
	
	public String getPassword() {

		return this.password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}
	
	public int getRoleId() {
		
		return this.roleId;
	}
	
	public void setRoleId(final int roleId) {
		
		this.roleId = roleId;
	}
}
