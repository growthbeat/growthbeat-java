package com.growthbeat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.growthbeat.constants.Constants;

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
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

}
