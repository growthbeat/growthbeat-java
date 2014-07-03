package com.growthbeat.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

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

	public static Client findById(String id, String credentialId) {
		return get(String.format("1/clients/%s", id), makeParams(credentialId), Client.class);
	}

	public static List<Client> findByApplicationId(String applicationId, String id, Order order, Integer limit, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("applicationId", applicationId);
		if (id != null)
			params.put("id", id);
		if (order != null)
			params.put("order", order);
		if (limit != null)
			params.put("limit", limit);
		return get("1/clients", params, new TypeReference<List<Client>>() {
		});
	}

	public static Client create(String applicationId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("applicationId", applicationId);
		return post("1/clients", params, Client.class);
	}

	public static void deleteByid(String id, String credentialId) {
		delete(String.format("1/clients/%s", id), makeParams(credentialId), Client.class);
	}

}
