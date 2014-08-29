package com.growthbeat.exception;

import com.growthbeat.model.Error;

public class GrowthbeatApiException extends GrowthbeatException {

	private static final long serialVersionUID = 1L;
	private static final int UNKNOWN = 500;

	private int statusCode;
	private Error error;

	public GrowthbeatApiException() {
		super();
	}

	public GrowthbeatApiException(String message, int statusCode) {
		super(message);
		setStatusCode(statusCode);
	}

	public GrowthbeatApiException(int statusCode) {
		this("Invalid status code: ", statusCode);
	}

	public GrowthbeatApiException(String message, Throwable cause) {
		super(message, cause);
		setStatusCode(UNKNOWN);
	}

	public GrowthbeatApiException(Throwable cause) {
		super(cause);
		setStatusCode(UNKNOWN);
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public GrowthbeatApiException withError(Error error) {
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
