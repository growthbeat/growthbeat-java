package com.growthbeat.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;

public class AccountUser extends Account {

	private String mail;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static List<AccountUser> findAccountUsersById(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return get(context, "/1/account_users_by_account_id", params, new TypeReference<List<AccountUser>>() {
		});
	}

	public static List<AccountUser> findAccountUsersByApplicationId(String applicationId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicationId", applicationId);
		return get(context, "/1/account_users_by_application_id", params, new TypeReference<List<AccountUser>>() {
		});
	}

	public static AccountUser create(String accountId, String name, String mail, String password, String company, String phone,
			boolean createApplication, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("name", name);
		params.put("mail", mail);
		params.put("password", password);
		params.put("company", company);
		params.put("phone", phone);
		params.put("createApplication", createApplication);
		return post(context, "1/account_users", params, AccountUser.class);
	}

	public static AccountUser update(String accountId, String name, String mail, String password, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("mail", mail);
		params.put("password", password);
		return put(context, String.format("1/account_users/%s", accountId), params, AccountUser.class);
	}

}
