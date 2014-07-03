package com.growthbeat.model;

import java.util.Date;
import java.util.Map;

public class Resource extends Model {

	private String id;
	private String name;
	private Date created;
	private Resource parentResource;

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

	public Resource getParentResource() {
		return parentResource;
	}

	public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}

	public static Resource findById(String id, String credentialId) {
		return get(String.format("1/resources/%s", id), makeParams(credentialId), Resource.class);
	}

	public static Resource create(String parentResourceId, String name, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("parentResourceId", parentResourceId);
		params.put("name", name);
		return post("1/resources", params, Resource.class);
	}

	public static Resource deleteById(String id, String credentialId) {
		return delete(String.format("1/resources/%s", id), makeParams(credentialId), Resource.class);
	}

}
