package com.growthbeat.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

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

	public static Credential findById(String id, String credentialId) {
		return get(String.format("1/credentials/%s", id), makeParams(credentialId), Credential.class);
	}

	public static Credential findByAccountId(String accountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		return get("1/credentials", params, Credential.class);
	}

	public static Credential create(String accountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		return post("1/credentials", params, Credential.class);
	}

	public static Credential deleteById(String id, String credentialId) {
		return delete(String.format("1/credentials/%s", id), makeParams(credentialId), Credential.class);
	}

	public static List<Credential> findBySessionId(String sessionId, String credentialId) {
		Map<String, Object> params = makeParams(sessionId);
		params.put("sessionId", sessionId);
		return get("1/credentials", params, new TypeReference<List<Credential>>() {
		});
	}
}
