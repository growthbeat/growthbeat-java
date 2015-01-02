package com.growthbeat.model;

import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

public class AccountUser extends Account {

	private String mail;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static AccountUser create(String accountId, String name, String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("name", name);
		params.put("mail", mail);
		return post(context, "0/accounts", params, AccountUser.class);
	}

}
