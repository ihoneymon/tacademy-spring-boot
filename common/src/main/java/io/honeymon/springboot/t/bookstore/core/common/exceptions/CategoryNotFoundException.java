package io.honeymon.springboot.t.bookstore.core.common.exceptions;

public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryNotFoundException(String message) {
		super(message);
	}

	
}
