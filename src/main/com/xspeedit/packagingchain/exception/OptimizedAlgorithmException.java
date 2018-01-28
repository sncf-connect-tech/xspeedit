package com.xspeedit.packagingchain.exception;

/**
 * classe permet de gerer les expcetions remonté par le service OptimizedAlgorithm
 * @author A370276
 *
 */
public class OptimizedAlgorithmException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public OptimizedAlgorithmException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
