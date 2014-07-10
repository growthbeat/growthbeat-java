package com.growthbeat;

import com.growthbeat.http.HttpClient;

public class Growthbeat {

	private String credentialId;

	public Growthbeat() {
		super();
	}

	public Growthbeat(String credentialId) {
		this();
		setCredentialId(credentialId);
	}

	public String getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(String credentialId) {
		this.credentialId = credentialId;
	}

	public void setHttpClientBaseUrl(String baseUrl) {
		HttpClient.getInstance().setBaseUrl(baseUrl);
	}

}
