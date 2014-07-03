package com.growthbeat;

import com.growthbeat.utils.HttpClient;

public class Growthbeat {

	private static Growthbeat instance = new Growthbeat();

	private Growthbeat() {
		super();
	}

	public static Growthbeat getInstance() {
		return instance;
	}

	public void setHttpClientBaseUrl(String baseUrl) {
		HttpClient.getInstance().setBaseUrl(baseUrl);
	}

}
