package com.growthbeat.exception;

import com.growthbeat.model.Error;

public class ApiException extends GrowthbeatException {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	private Error error;

	public ApiException(int statusCode) {
		super();
		setStatusCode(statusCode);
	}

	public ApiException(int statusCode, Error error) {
		this(statusCode);
		setError(error);
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
