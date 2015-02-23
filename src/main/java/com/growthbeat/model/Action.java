package com.growthbeat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Action extends Model {

	private String id;
	private String name;
	private Date created;
	private Action parentAction;

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Action getParentAction() {
		return parentAction;
	}

	public void setParentAction(Action parentAction) {
		this.parentAction = parentAction;
	}

}
