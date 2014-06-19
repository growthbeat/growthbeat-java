package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

public class Credential extends Model {

	private String id;
	private Date created;
	private Account account;

	public static List<Credential> getByConnectionIdAndServiceSecret(String connectionId, String serviceSecret) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("connectionId", connectionId);
		params.put("serviceSecret", serviceSecret);

		List<Credential> credentials = get(1, "credentials", params, new TypeReference<List<Credential>>() {
		});

		return credentials;

	}

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

}
