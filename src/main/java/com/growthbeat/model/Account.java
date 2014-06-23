package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	public static Account findById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		return get(1, String.format("accounts/%s", id), params, Account.class);

	}

	public static Account create() {

		return post(1, "accounts", new HashMap<String, Object>(), Account.class);

	}

	public static Account deleteById(String id) {
		return delete(1, String.format("accounts/%s", id), new HashMap<String, Object>(), Account.class);
	}

}
