package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class TemporarySession extends Model {

	private String id;
	private Account account;
	private Service service;
	private Date created;

	public TemporarySession() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static TemporarySession findById(String id, Context context) {
		return get(context, String.format("1/temporary_sessions/%s", id), new HashMap<String, Object>(), TemporarySession.class);
	}

	public static TemporarySession create(String accountId, String serviceId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		return post(context, "1/temporary_sessions", params, TemporarySession.class);
	}

}
