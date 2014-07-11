package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

public class Session extends Model {

	private String id;
	private Date created;
	private Account account;
	private Service service;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public static Session findById(String id, Context context) {
		return get(context, String.format("1/sessions/%s", id), new HashMap<String, Object>(), Session.class);
	}

	public static Session create(String accountId, String serviceId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		return post(context, "1/sessions", params, Session.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/sessions/%s", id), new HashMap<String, Object>(), Void.class);
	}

}
