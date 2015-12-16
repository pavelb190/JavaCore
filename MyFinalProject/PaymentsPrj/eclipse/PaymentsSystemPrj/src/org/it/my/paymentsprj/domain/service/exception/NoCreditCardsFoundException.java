package org.it.my.paymentsprj.domain.service.exception;

public class NoCreditCardsFoundException extends Exception {
	
	public NoCreditCardsFoundException(final String message) {
		
		super(message);
	}
}
