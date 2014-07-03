package com.growthbeat.model;

import java.util.Date;

public class Account extends Model {

	private String id;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static Account findById(String id, String credentialId) {
		return get(String.format("1/accounts/%s", id), makeParams(credentialId), Account.class);
	}

	public static Account create(String credentialId) {
		return post("1/accounts", makeParams(credentialId), Account.class);
	}

	public static void deleteById(String id, String credentialId) {
		delete(String.format("1/accounts/%s", id), makeParams(credentialId), Account.class);
	}
}
