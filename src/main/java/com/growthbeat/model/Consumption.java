package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;
import com.growthbeat.utils.JsonUtils;

public class Consumption extends Model {

	private int count;
	private Date created;
	private Account account;
	private Resource resource;
	private Action action;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
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

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public static Consumption create(String accountId, String resourceId, String actionId, int count, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		params.put("count", count);
		return post(context, "1/consumptions", params, Consumption.class);
	}

	public static List<Consumption> create(List<Map<String, String>> consumptions, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("consumptions", JsonUtils.serialize(consumptions));
		return post(context, "1/consumptions", params, new TypeReference<List<Consumption>>() {
		});
	}

}
