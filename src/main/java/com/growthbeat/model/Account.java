package com.growthbeat.model;

import java.util.Date;

import com.growthbeat.Context;

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

	public static Account findById(String id, Context context) {
		return get(context, String.format("1/accounts/%s", id), makeParams(context), Account.class);
	}

	public static Account create(Context context) {
		return post(context, "1/accounts", makeParams(context), Account.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/accounts/%s", id), makeParams(context));
	}
}
