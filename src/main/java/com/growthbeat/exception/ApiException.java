package com.growthbeat.exception;

import com.growthbeat.model.Error;

public class ApiException extends GrowthbeatException {

	private static final long serialVersionUID = 1L;
	private static final int UNKNOWN = 500;

	private int statusCode;
	private Error error;

	public ApiException() {
		super();
	}

	public ApiException(String message, int statusCode) {
		super(message);
		setStatusCode(statusCode);
	}

	public ApiException(int statusCode) {
		this(String.format("Invalid status code: %d", statusCode), statusCode);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
		setStatusCode(UNKNOWN);
	}

	public ApiException(Throwable cause) {
		super(cause);
		setStatusCode(UNKNOWN);
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public ApiException withError(Error error) {
		setError(error);
		return this;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
