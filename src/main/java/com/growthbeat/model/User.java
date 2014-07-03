package com.growthbeat.model;

import java.util.Date;
import java.util.Map;

public class User extends Model {

	private String mail;
	private Date created;
	private Account account;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

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

	public static User findByAccountId(String accountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		return get("1/users", params, User.class);
	}

	public static User create(String accountId, String mail, String password, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("mail", mail);
		params.put("password", password);
		return post("1/users", params, User.class);
	}

	public static User create(String mail, String password, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("mail", mail);
		params.put("password", password);
		return post("1/users", params, User.class);
	}

	public static User updateMail(String accountId, String mail, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("mail", mail);
		return put("1/users", params, User.class);
	}

	public static User updatePassword(String accountId, String currentPassword, String password, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		params.put("currentPassword", currentPassword);
		params.put("password", password);
		return put("1/users", params, User.class);
	}

	public static void deleteByAccountId(String accountId, String credentialId) {
		Map<String, Object> params = makeParams(credentialId);
		params.put("accountId", accountId);
		post("1/users", params);
	}

}
