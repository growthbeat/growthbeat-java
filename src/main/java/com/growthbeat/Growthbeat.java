package com.growthbeat;

import java.util.List;

import com.growthbeat.model.Account;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Connection;
import com.growthbeat.model.Consumption;
import com.growthbeat.model.Credential;
import com.growthbeat.model.Order;
import com.growthbeat.model.Permission;
import com.growthbeat.model.Plan;
import com.growthbeat.model.User;

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

	public Account createAccount(String name) {
		return Account.create(name, context);
	}

	public Application findApplicationById(String id) {
		return Application.findById(id, context);
	}

	public List<Application> findApplicationByAccountId(String accounId) {
		return Application.findByAccountId(accounId, context);
	}

	public Application createApplication(String name) {
		return Application.create(name, context);
	}

	public Application updateApplication(String id, String name) {
		return Application.update(id, name, context);
	}

	public Client findClientById(String id) {
		return Client.findById(id, context);
	}

	public List<Client> findClientByApplicationId(String applicationId, String id, Order order, Integer limit) {
		return Client.findByApplicationId(applicationId, id, order, limit, context);
	}

	public Client createClient(String applicationId) {
		return Client.create(applicationId, context);
	}

	public Connection findConnectionByChildAccountId(String childAccountId) {
		return Connection.findByChildAccountId(childAccountId, context);
	}

	public Consumption createConsumption(String accountId, String actionId, int count) {
		return Consumption.create(accountId, actionId, count, context);
	}

	public Credential findCredentialById(String id) {
		return Credential.findById(id, context);
	}

	public List<Credential> findCredentialByAccountId(String accountId) {
		return Credential.findByAccountId(accountId, context);
	}

	public Credential createCredential(String accountId) {
		return Credential.create(accountId, context);
	}

	public List<Credential> findCredentialBySessionId(String sessionId) {
		return Credential.findBySessionId(sessionId, context);
	}

	public List<Permission> findPermissionByAccountId(String accountId) {
		return Permission.findByAccountId(accountId, context);
	}

	public List<Permission> findPermissionByTargetAccountId(String targetAccountId) {
		return Permission.findByTargetAccountId(targetAccountId, context);
	}

	public List<Permission> findPermissionByAccountIdAndTargetAccountId(String accountId, String targetAccountId) {
		return Permission.findByAccountIdAndTargetAccountId(accountId, targetAccountId, context);
	}

	public Permission createPermission(String accountId, String targetAccountId, String resourceId, String actionId) {
		return Permission.create(accountId, targetAccountId, resourceId, actionId, context);
	}

	public void deletePermission(String accountId, String targetAccountId, String resourceId, String actionId) {
		Permission.delete(accountId, targetAccountId, resourceId, actionId, context);
	}

	public Plan findPlanByAccountId(String accountId) {
		return Plan.findByAccountId(accountId, context);
	}

	public boolean authorize(String resourceId, String actionId) {
		return Permission.authorize(resourceId, actionId, context);
	}

	public User findUserByAccountId(String accountId) {
		return User.findByAccountId(accountId, context);
	}

	public User createUser(String mail, String password, String name, String company, String phone) {
		return User.create(mail, password, name, company, phone, context);
	}

}
