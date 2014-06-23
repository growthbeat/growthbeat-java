package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
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

	public static Resource findById(String id) {
		return get(1, String.format("resources/%s", id), new HashMap<String, Object>(), Resource.class);
	}

	public static Resource create(String parentResourceId, String name) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentResourceId", parentResourceId);
		params.put("name", name);

		return post(1, "resources", params, Resource.class);

	}

	public static Resource deleteById(String id) {
		return delete(1, String.format("resources/%s", id), new HashMap<String, Object>(), Resource.class);
	}

}
