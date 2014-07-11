package com.growthbeat;

import com.growthbeat.model.Account;
import com.growthbeat.model.Action;

public class Growthbeat {

	private static final String BASE_URL = "https://api.growthbeat.com/";

	private Context context = new Context();

	public Growthbeat() {
		super();
		context.getGrowthbeatHttpClient().setBaseUrl(BASE_URL);
	}

	public Growthbeat(String credentialId) {
		this();
		context.setCredentialId(credentialId);
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Account findAccountById(String id) {
		return Account.findById(id, context);
	}

	public Account createAccount() {
		return Account.create(context);
	}

	public void deleteAccountById(String id) {
		Account.deleteById(id, context);
	}

	public Action findActionById(String id) {
		return Action.findById(id, context);
	}

	public Action createAction(String parentActionId, String name) {
		return Action.create(parentActionId, name, context);
	}

	public void deleteActionById(String id) {
		Action.deleteById(id, context);
	}

}
