package com.growthbeat.utils;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class HttpRequest extends HttpEntityEnclosingRequestBase {

	private String method;

	public HttpRequest() {
		super();
	}

	public HttpRequest(URI uri) {
		super();
		setURI(uri);
	}

	public HttpRequest(String uri) {
		super();
		setURI(URI.create(uri));
	}

	@Override
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
