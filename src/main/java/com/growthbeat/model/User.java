package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class User extends Model {

	private String mail;
	private String thumbnail;
	private String company;
	private String phone;
	private boolean subscription;
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

	public boolean getSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
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

	public static User findByMail(String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mail", mail);
		return get(context, "1/users", params, User.class);
	}

	public static List<User> findByAccountIdAndApplicationId(String accountId, String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("applicationId", applicationId);
		return get(context, "1/users", params, new TypeReference<List<User>>() {
		});
	}

	public static User create(String mail, String password, String name, String company, String phone, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mail", mail);
		params.put("password", password);
		if (name != null)
			params.put("name", name);
		if (company != null)
			params.put("company", company);
		if (phone != null)
			params.put("phone", phone);
		return post(context, "1/users", params, User.class);
	}

	public static User create(String accountId, String mail, String password, String name, String company, String phone,
			boolean createApplication, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("mail", mail);
		params.put("password", password);
		if (name != null)
			params.put("name", name);
		if (company != null)
			params.put("company", company);
		if (phone != null)
			params.put("phone", phone);
		return post(context, "1/users", params, User.class);
	}

	public static User invite(String mail, String password, String name, String company, String phone, String accountId, String resourceId,
			String actionId, String serviceId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mail", mail);
		params.put("password", password);
		if (name != null)
			params.put("name", name);
		if (company != null)
			params.put("company", company);
		if (phone != null)
			params.put("phone", phone);
		params.put("accountId", accountId);
		params.put("resourceId", resourceId);
		params.put("actionId", actionId);
		if (serviceId != null)
			params.put("serviceId", serviceId);
		return post(context, "1/users/invite", params, User.class);
	}

	public static User update(String accountId, String mail, String password, String company, String phone, Boolean subscription,
			Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("mail", mail);
		params.put("password", password);
		if (company != null)
			params.put("company", company);
		if (phone != null)
			params.put("phone", phone);
		if (subscription != null)
			params.put("subscription", subscription);
		return put(context, "1/users", params, User.class);
	}

}
