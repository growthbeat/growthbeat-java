package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class Permission extends Model {

	private Account account;
	private Account targetAccount;
	private Resource resource;
	private Action action;
	private Date created;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static List<Permission> findByAccountId(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return get(context, "1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static List<Permission> findByTargetAccountId(String targetAccountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("targetAccountId", targetAccountId);
		return get(context, "1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static List<Permission> findByAccountIdAndTargetAccountId(String accountId, String targetAccountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		return get(context, "1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static Permission create(String accountId, String targetAccountId, String resourceId, String actionId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		return post(context, "1/permissions", params, Permission.class);
	}

	public static Permission createByMail(String accountId, String targetMail, String resourceId, String actionId, String serviceId,
			Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("targetMail", targetMail);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		if (serviceId != null)
			params.put("serviceId", serviceId);
		return post(context, "1/permissions", params, Permission.class);
	}

	public static void delete(String accountId, String targetAccountId, String resourceId, String actionId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		delete(context, "1/permissions", params, Void.class);
	}

	public static void deleteByTargetAccountId(String deleterAccountId, String targetAccountId, String resourceId, String actionId,
			Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleterAccountId", deleterAccountId);
		params.put("targetAccountId", targetAccountId);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		delete(context, "1/permissions", params, Void.class);
	}

	public static boolean authorize(String resourceId, String actionId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		return post(context, "1/authorize", params, Boolean.class);
	}

}
