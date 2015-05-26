package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

@JsonDeserialize(using = JsonIntentDeserializer.class)
public abstract class Intent extends Model {

	private String id;
	private String applicationId;
	private String name;
	private String description;
	private IntentType type;
	private Date updated;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IntentType getType() {
		return type;
	}

	public void setType(IntentType type) {
		this.type = type;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static int findCountByApplicationId(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		return get(context, "1/intents/count", params, Integer.class);
	}

	public static Intent findById(String id, Context context) {
		return get(context, String.format("1/intents/%s", id), new HashMap<String, Object>(), Intent.class);
	}

	public static List<Intent> findByApplicationId(String applicationId, Order order, Integer page, Integer limit, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		if (order != null)
			params.put("order", order);
		if (page != null)
			params.put("page", page);
		if (limit != null)
			params.put("limit", limit);
		return get(context, "1/intents", params, new TypeReference<List<Intent>>() {
		});
	}

	public static Intent createCustomIntent(String applicationId, String name, String description, Map<String, String> parameters,
			Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.custom);
		params.put("parameters", parameters);
		return post(context, "1/intents", params, Intent.class);
	}

	public static Intent createNoopIntent(String applicationId, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.noop);
		return post(context, "1/intents", params, Intent.class);
	}

	public static Intent createUrlIntent(String applicationId, String name, String description, String url, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.url);
		params.put("url", url);
		return post(context, "1/intents", params, Intent.class);
	}

	public static Intent updateCustomIntent(String id, String name, String description, Map<String, String> parameters, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.custom);
		params.put("parameters", parameters);
		return put(context, String.format("1/intents/%s", id), params, Intent.class);
	}

	public static Intent updateNoopIntent(String id, String name, String description, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.noop);
		return put(context, String.format("1/intents/%s", id), params, Intent.class);
	}

	public static Intent updateUrlIntent(String id, String name, String description, String url, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("description", description);
		params.put("type", IntentType.url);
		params.put("url", url);
		return put(context, String.format("1/intents/%s", id), params, Intent.class);
	}

	public static void delete(String id, Context context) {
		delete(context, String.format("1/intents/%s", id), new HashMap<String, Object>(), Void.class);
	}

}
