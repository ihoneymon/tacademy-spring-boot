package io.honeymon.springboot.t.bookstore.core.common.exceptions;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNotFoundException(String message) {
		super(message);
	}

}
