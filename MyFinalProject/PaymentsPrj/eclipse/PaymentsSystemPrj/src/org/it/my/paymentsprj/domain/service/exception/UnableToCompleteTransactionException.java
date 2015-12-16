package org.it.my.paymentsprj.domain.service.exception;

public class UnableToCompleteTransactionException extends Exception {
	
	public UnableToCompleteTransactionException(final String message, Throwable cause) {
		
		super(message, cause);
	}
}
