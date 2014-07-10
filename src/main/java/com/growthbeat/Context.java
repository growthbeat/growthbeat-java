package com.growthbeat;

import com.growthbeat.http.GrowthbeatHttpClient;

public class Context {

	private String credentialId = null;
	private GrowthbeatHttpClient growthbeatHttpClient = new GrowthbeatHttpClient();

	public Context() {
		super();
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
