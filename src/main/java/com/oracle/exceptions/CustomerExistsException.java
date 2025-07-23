package com.oracle.exceptions;

public class CustomerExistsException  extends RuntimeException{
	public CustomerExistsException(String msg) {
		super(msg);
	}
	public CustomerExistsException(String msg, Throwable cause) {
		super(msg , cause);
	}
	public CustomerExistsException(Throwable cause) {
		super(cause);
	}
}
