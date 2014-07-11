package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;

public class Credential extends Model {

	private String id;
	private Date created;
	private Account account;

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

	public static Credential findById(String id, Context context) {
		return get(context, String.format("1/credentials/%s", id), new HashMap<String, Object>(), Credential.class);
	}

	public static List<Credential> findByAccountId(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return get(context, "1/credentials", params, new TypeReference<List<Credential>>() {
		});
	}

	public static Credential create(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return post(context, "1/credentials", params, Credential.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/credentials/%s", id), new HashMap<String, Object>(), Void.class);
	}

	public static List<Credential> findBySessionId(String sessionId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", sessionId);
		return get(context, "1/credentials", params, new TypeReference<List<Credential>>() {
		});
	}
}
