package com.oracle.exceptions;

public class NoSuchCustomerException extends RuntimeException {

	public NoSuchCustomerException(String msg) {
		super(msg);
	}
	public NoSuchCustomerException(String msg, Throwable cause) {
		super(msg , cause);
	}
	public NoSuchCustomerException(Throwable cause) {
		super(cause);
	}
}
