package org.it.my.paymentsprj.dal.dto;

import java.util.Date;

public class Transaction extends Entity {
	
	private long accountId;

	private double moneyAmount;

	private boolean payment;

	private String description;
	
	private Date committedAt;

	public long getAccountId() {

		return this.accountId;
	}

	public void setAccountId(final long accountId) {

		this.accountId = accountId;
	}

	public double getMoneyAmount() {

		return this.moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {

		this.moneyAmount = moneyAmount;
	}

	public boolean isPayment() {

		return this.payment;
	}

	public void setPayment(boolean isPayment) {

		this.payment = isPayment;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
	
	public Date getCommittedAt() {
		
		return this.committedAt;
	}
	
	public void setCommittedAt(Date committedAt) {
		
		this.committedAt = committedAt;
	}
}
