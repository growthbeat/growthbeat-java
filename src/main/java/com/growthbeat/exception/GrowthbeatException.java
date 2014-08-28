package com.growthbeat.exception;

public class GrowthbeatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GrowthbeatException() {
		super();
	}

	public GrowthbeatException(String message) {
		super(message);
	}

	public GrowthbeatException(String message, Throwable cause) {
		super(message, cause);
	}

	public GrowthbeatException(Throwable cause) {
		super(cause);
	}

}
