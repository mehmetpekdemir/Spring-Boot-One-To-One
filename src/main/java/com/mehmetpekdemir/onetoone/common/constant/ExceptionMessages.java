package com.mehmetpekdemir.onetoone.common.constant;

/**
 * 
 * Exception Messages
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class ExceptionMessages {

	private static final String UTILITY_CLASS = "Utility Class";

	private ExceptionMessages() {
		throw new IllegalArgumentException(UTILITY_CLASS);
	}

	public static final String USER_NOT_FOUND = "User Not Found ! ";

	public static final String USER_INFORMATION_NOT_FOUND = "User Information Not Found ! ";

}
