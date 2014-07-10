package com.growthbeat;

import com.growthbeat.http.GrowthbeatHttpClient;

public class Growthbeat {

	private static final String BASE_URL = "https://api.growthbeat.com/";

	private String credentialId = null;
	private GrowthbeatHttpClient growthbeatHttpClient = new GrowthbeatHttpClient(BASE_URL);

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

	public GrowthbeatHttpClient getGrowthbeatHttpClient() {
		return growthbeatHttpClient;
	}

	public void setGrowthbeatHttpClient(GrowthbeatHttpClient growthbeatHttpClient) {
		this.growthbeatHttpClient = growthbeatHttpClient;
	}

}
