package org.it.my.paymentsprj.domain.service.exception;

public class UserHasNoPermissionsException extends Exception {

	public UserHasNoPermissionsException(final String message) {
		
		super(message);
	}
}
