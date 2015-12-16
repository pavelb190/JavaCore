package org.it.my.paymentsprj.domain.service.exception;

public class BankAccountNotFoundException extends Exception {
	
	public BankAccountNotFoundException(final String message) {
		
		super(message);
	}
}
