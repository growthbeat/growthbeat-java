package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	public static Client findById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		return get(String.format("1/clients/%s", id), params, Client.class);

	}

	public static Client findByApplicationId(String applicationId, String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("id", id);

		return get("1/clients", params, Client.class);

	}

	public static Client create(String applicationId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);

		return post("1/clients", params, Client.class);

	}

}
