package com.growthbeat.model;

import java.util.Map;

public class CustomIntent extends Intent {

	private Map<String, String> extra;

	public Map<String, String> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, String> extra) {
		this.extra = extra;
	}

}
