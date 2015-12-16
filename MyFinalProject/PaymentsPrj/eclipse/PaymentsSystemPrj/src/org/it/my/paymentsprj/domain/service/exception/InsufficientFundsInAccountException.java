package org.it.my.paymentsprj.domain.service.exception;

public class InsufficientFundsInAccountException extends Exception {
	
	public InsufficientFundsInAccountException(final String message) {
		
		super(message);
	}
}
