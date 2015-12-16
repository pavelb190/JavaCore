package org.it.my.paymentsprj.dal.dto;

public class BankAccount extends Entity {
	
	private long userId;
	
	private double balance;
	
	private boolean available;

	public long getUserId() {

		return this.userId;
	}

	public void setUserId(final long userId) {

		this.userId = userId;
	}

	public double getBalance() {

		return this.balance;
	}

	public void setBalance(double balance) {

		this.balance = balance;
	}

	public boolean isAvailable() {

		return this.available;
	}

	public void setAvailable(boolean available) {

		this.available = available;
	}
}
