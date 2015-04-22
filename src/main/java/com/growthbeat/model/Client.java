package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class Client extends Model {

	private String id;
	private Date created;
	private Application application;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public static Client findById(String id, Context context) {
		return get(context, String.format("1/clients/%s", id), new HashMap<String, Object>(), Client.class);
	}

	public static List<Client> findByApplicationId(String applicationId, String id, Order order, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		if (id != null)
			params.put("id", id);
		if (order != null)
			params.put("order", order);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "1/clients", params, new TypeReference<List<Client>>() {
		});
	}

	public static Client create(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		return post(context, "1/clients", params, Client.class);
	}

}
