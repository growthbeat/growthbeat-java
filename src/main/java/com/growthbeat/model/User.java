package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

public class User extends Model {

	private String mail;
	private String thumbnail;
	private String name;
	private String company;
	private String phone;
	private Date created;
	private Account account;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public static User findByAccountId(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return get(context, "1/users", params, User.class);
	}

	public static User create(String accountId, String mail, String password, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("mail", mail);
		params.put("password", password);
		return post(context, "1/users", params, User.class);
	}

	public static User create(String mail, String password, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mail", mail);
		params.put("password", password);
		return post(context, "1/users", params, User.class);
	}

	public static User updateMail(String accountId, String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("mail", mail);
		return put(context, "1/users", params, User.class);
	}

	public static User updatePassword(String accountId, String currentPassword, String password, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("currentPassword", currentPassword);
		params.put("password", password);
		return put(context, "1/users", params, User.class);
	}

	public static void deleteByAccountId(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		post(context, "1/users", params, Void.class);
	}

}
