package org.it.my.paymentsprj.dal.entity;

public class BankAccount extends Entity {
	
	private long userId;
	
	private double balance;
	
	private boolean isAvailable;

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

		return this.isAvailable;
	}

	public void isAvailable(boolean available) {

		this.isAvailable = available;
	}
}
