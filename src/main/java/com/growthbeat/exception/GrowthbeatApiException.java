package com.growthbeat.exception;

import com.growthbeat.model.Error;

public class GrowthbeatApiException extends GrowthbeatException {

	private static final long serialVersionUID = 1L;

	private Error error;

	public GrowthbeatApiException() {
		super();
	}

	public GrowthbeatApiException(String message) {
		super(message);
	}

	public GrowthbeatApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public GrowthbeatApiException(Throwable cause) {
		super(cause);
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

}
