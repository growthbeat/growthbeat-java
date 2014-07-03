package com.growthbeat.model;

import java.util.Date;
import java.util.Map;

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

	public static Session findById(String id, String credentialId) {
		return get(String.format("1/sessions/%s", id), makeParams(credentialId), Session.class);
	}

	public static Session create(String accountId, String serviceId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		return post("1/sessions", params, Session.class);
	}

	public static void deleteById(String id, String credentialId) {
		delete(String.format("1/sessions/%s", id), makeParams(credentialId));
	}

}
