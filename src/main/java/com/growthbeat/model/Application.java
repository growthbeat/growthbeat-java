package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	public static Application findById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		return get(String.format("1/applications/%s", id), params, Application.class);

	}

	public static Application findByAccountId(String accounId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accounId);

		return get("1/applications", params, Application.class);

	}

	public static Application update(String id, String name) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);

		return put(String.format("1/applications/%s", id), params, Application.class);

	}

	public static Application deleteByid(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		return delete(String.format("1/applications/%s", id), params, Application.class);

	}
}
