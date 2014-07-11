package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

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

	public static Action findById(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return get(context, "1/actions", params, Action.class);
	}

	public static Action create(String parentActionId, String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentActionId", parentActionId);
		params.put("name", name);
		return post(context, "1/actions", params, Action.class);
	}

	public static void deleteById(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		delete(context, "1/actions", params, Void.class);
	}

}
