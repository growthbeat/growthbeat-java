package com.growthbeat.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

public class Permission extends Model {

	private Date created;
	private Account account;
	private Account targetAccount;
	private Resource resource;
	private Action action;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

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

	public static List<Permission> findByAccountId(String accountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		return get("1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static List<Permission> findByTargetAccountId(String targetAccountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("targetAccountId", targetAccountId);
		return get("1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static List<Permission> findByAccountIdAndTargetAccountId(String accountId, String targetAccountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		return get("1/permissions", params, new TypeReference<List<Permission>>() {
		});
	}

	public static Permission create(String accountId, String targetAccountId, String resourceId, String actionId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		params.put("resouceId", resourceId);
		params.put("actionId", actionId);
		return post("1/permissions", params, Permission.class);
	}

	public static void deleteById(String accountId, String targetAccountId, String resourceId, String actionId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("targetAccountId", targetAccountId);
		params.put("resouceId", resourceId);
		params.put("actionId", actionId);
		delete("1/permissions", params);
	}

	public static boolean authorize(String accountId, String resourceId, String actionId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("resouceId", resourceId);
		params.put("actionId", actionId);
		return post("1/authorize", params, Boolean.class);
	}

}
