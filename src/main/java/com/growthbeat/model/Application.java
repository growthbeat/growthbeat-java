package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;
import com.growthbeat.utils.StringUtils;

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static Application findById(String id, Context context) {
		return get(context, String.format("1/applications/%s", StringUtils.urlEncode(id)), new HashMap<String, Object>(), Application.class);
	}

	public static List<Application> findByAccountId(String accounId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accounId);
		return get(context, "1/applications", params, new TypeReference<List<Application>>() {
		});
	}

	public static Application create(String accountId, String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (accountId != null)
			params.put("accountId", accountId);
		params.put("name", name);
		return post(context, "1/applications", params, Application.class);
	}

	public static Application update(String id, String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return put(context, String.format("1/applications/%s", StringUtils.urlEncode(id)), params, Application.class);
	}
}
