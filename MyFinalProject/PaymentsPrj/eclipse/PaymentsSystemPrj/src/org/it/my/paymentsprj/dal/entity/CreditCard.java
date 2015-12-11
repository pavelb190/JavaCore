package org.it.my.paymentsprj.dal.entity;

public class CreditCard extends Entity {
	
	private long accountId;

	public long getAccountId() {

		return this.accountId;
	}

	public void setAccountId(final long accountId) {

		this.accountId = accountId;
	}
}
