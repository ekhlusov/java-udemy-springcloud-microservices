package ru.ekhlusov.account.exception;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */
public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String message) {
		super(message);
	}
}
