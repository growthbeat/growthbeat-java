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

	public static List<AccountUser> findAccountUsersById(String id, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return get(context, "/0/account_users_by_account_id", params, new TypeReference<List<AccountUser>>() {
		});
	}

	public static AccountUser create(String accountId, String name, String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("name", name);
		params.put("mail", mail);
		return post(context, "0/account_users", params, AccountUser.class);
	}

	public static AccountUser update(String accountId, String name, String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("mail", mail);
		return put(context, String.format("0/account_users/%s", accountId), params, AccountUser.class);
	}

}
