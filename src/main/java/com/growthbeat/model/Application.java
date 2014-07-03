package com.growthbeat.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

public class Application extends Model {

	private String id;
	private String name;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static Application findById(String id, String credentialId) {
		return get(String.format("1/applications/%s", id), makeParams(credentialId), Application.class);
	}

	public static List<Application> findByAccountId(String accounId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accounId);
		return get("1/applications", params, new TypeReference<List<Application>>() {
		});
	}

	public static Application update(String id, String name, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("name", name);
		return put(String.format("1/applications/%s", id), params, Application.class);
	}

	public static void deleteByid(String id, String credentialId) {
		delete(String.format("1/applications/%s", id), makeParams(credentialId), Application.class);
	}
}
