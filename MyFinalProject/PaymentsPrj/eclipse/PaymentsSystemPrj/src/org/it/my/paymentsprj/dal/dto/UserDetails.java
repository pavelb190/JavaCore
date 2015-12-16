package org.it.my.paymentsprj.dal.dto;

public class UserDetails extends User {
	
	private int accountBlockedCount;
	
	private int accountAvailableCount;
	
	public int getAccountBlockedCount() {
		
		return this.accountBlockedCount;
	}
	
	public void setAccountBlockedCount(int accountBlockedCount) {
		
		this.accountBlockedCount = accountBlockedCount;
	}
	
	public int getAccountAvailableCount() {
		
		return this.accountAvailableCount;
	}
	
	public void setAccountAvailableCount(int accountAvailableCount) {
		
		this.accountAvailableCount = accountAvailableCount;
	}
}
