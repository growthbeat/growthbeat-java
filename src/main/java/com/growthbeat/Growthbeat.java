package com.growthbeat;

import java.util.List;

import com.growthbeat.model.Account;
import com.growthbeat.model.AccountUser;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Consumption;
import com.growthbeat.model.Credential;
import com.growthbeat.model.Order;
import com.growthbeat.model.Permission;
import com.growthbeat.model.Plan;
import com.growthbeat.model.Session;
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

	public Account findAccountByAccountId(String accountId) {
		return Account.findById(accountId, context);
	}

	public List<Account> findAccountsByAccountId(String accountId) {
		return Account.findAccountsById(accountId, context);
	}

	public Account createAccount(String accountId, String name) {
		return Account.create(accountId, name, context);
	}

	public AccountUser createAccountUser(String accountId, String name, String mail) {
		return AccountUser.create(accountId, name, mail, context);
	}

	public AccountUser updateAccountUser(String accountId, String name, String mail) {
		return AccountUser.update(accountId, name, mail, context);
	}

	public Application findApplicationByApplicationId(String applicationId) {
		return Application.findById(applicationId, context);
	}

	public List<Application> findApplicationsByAccountId(String accounId) {
		return Application.findByAccountId(accounId, context);
	}

	public Application createApplication(String accountId, String name) {
		return Application.create(accountId, name, context);
	}

	public Application updateApplication(String applicationId, String name) {
		return Application.update(applicationId, name, context);
	}

	public Client findClientByClientId(String clientId) {
		return Client.findById(clientId, context);
	}

	public List<Client> findClientsByApplicationId(String applicationId, String clientId, Order order, Integer limit) {
		return Client.findByApplicationId(applicationId, clientId, order, limit, context);
	}

	public Client createClient(String applicationId) {
		return Client.create(applicationId, context);
	}

	public Consumption createConsumption(String accountId, String actionId, int count) {
		return Consumption.create(accountId, actionId, count, context);
	}

	public Credential findCredentialByCredentialId(String credentialId) {
		return Credential.findById(credentialId, context);
	}

	public List<Credential> findCredentialsByAccountId(String accountId) {
		return Credential.findByAccountId(accountId, context);
	}

	public List<Credential> findCredentialsBySessionId(String sessionId) {
		return Credential.findBySessionId(sessionId, context);
	}

	public Credential createCredential(String accountId) {
		return Credential.create(accountId, context);
	}

	public List<Permission> findPermissionsByAccountId(String accountId) {
		return Permission.findByAccountId(accountId, context);
	}

	public List<Permission> findPermissionsByTargetAccountId(String targetAccountId) {
		return Permission.findByTargetAccountId(targetAccountId, context);
	}

	public List<Permission> findPermissionsByAccountIdAndTargetAccountId(String accountId, String targetAccountId) {
		return Permission.findByAccountIdAndTargetAccountId(accountId, targetAccountId, context);
	}

	public Permission createPermission(String accountId, String targetAccountId, String resourceId, String actionId) {
		return Permission.create(accountId, targetAccountId, resourceId, actionId, context);
	}

	public void deletePermission(String accountId, String targetAccountId, String resourceId, String actionId) {
		Permission.delete(accountId, targetAccountId, resourceId, actionId, context);
	}

	public void deletePermission(String targetAccountId, String resourceId, String actionId) {
		Permission.delete(targetAccountId, resourceId, actionId, context);
	}

	public boolean authorize(String resourceId, String actionId) {
		return Permission.authorize(resourceId, actionId, context);
	}

	public Plan findPlanByAccountId(String accountId) {
		return Plan.findByAccountId(accountId, context);
	}

	public Session findSessionBySessionId(String sessionId) {
		return Session.findById(sessionId, context);
	}

	public User findUserByAccountId(String accountId) {
		return User.findByAccountId(accountId, context);
	}

	public User findUserByMail(String mail) {
		return User.findByMail(mail, context);
	}

	public User createUser(String mail, String password, String name, String company, String phone) {
		return User.create(mail, password, name, company, phone, context);
	}

}
