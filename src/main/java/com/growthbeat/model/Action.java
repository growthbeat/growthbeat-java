package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	static Action findById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return get("1/actions", params, Action.class);

	}

	static Action create(String parentActionId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentActionId", parentActionId);

		return post("1/actions", params, Action.class);

	}

	static Action deleteById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		return delete("1/actions", params, Action.class);

	}

}
