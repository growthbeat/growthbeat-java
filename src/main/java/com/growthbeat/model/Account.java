package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class Account extends Model {

	private String id;
	private String name;
	private Date created;

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

	public static Account findById(String id, Context context) {
		return get(context, String.format("1/accounts/%s", id), new HashMap<String, Object>(), Account.class);
	}

	public static List<Account> findAccountsById(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return get(context, "1/accounts", params, new TypeReference<List<Account>>() {
		});
	}

	public static Account create(String accountId, String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (accountId != null)
			params.put("accountId", accountId);
		params.put("name", name);
		return post(context, "1/accounts", params, Account.class);
	}

	public static Account update(String accountId, String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return put(context, "1/accounts/" + accountId, params, Account.class);
	}

	public static Account updateIcon(String id, MultipartFile icon, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("icon", icon);
		return put(context, String.format("/1/accounts/icon/%s", id), params, Account.class);
	}
}
