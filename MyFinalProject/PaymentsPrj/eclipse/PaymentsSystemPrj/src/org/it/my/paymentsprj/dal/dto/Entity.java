package org.it.my.paymentsprj.dal.dto;

public abstract class Entity {
	
	private long id;

	public long getId() {

		return this.id;
	}

	public void setId(long id) {

		this.id = id;
	}
}
