package com.growthbeat;

import java.util.List;
import java.util.Map;

import com.growthbeat.model.Account;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Consumption;
import com.growthbeat.model.Credential;
import com.growthbeat.model.GooglePartner;
import com.growthbeat.model.Intent;
import com.growthbeat.model.Order;
import com.growthbeat.model.Permission;
import com.growthbeat.model.Plan;
import com.growthbeat.model.RecoveryToken;
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

	public Account updateAccount(String accountId, String name) {
		return Account.update(accountId, name, context);
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

	public Consumption createConsumption(String accountId, String resourceId, String actionId, int count) {
		return Consumption.create(accountId, resourceId, actionId, count, context);
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

	public int findIntentCountByApplicationId(String applicationId) {
		return Intent.findCountByApplicationId(applicationId, context);
	}

	public Intent findIntentById(String intentId) {
		return Intent.findById(intentId, context);
	}

	public List<Intent> findIntentsByApplicationId(String applicationId, Order order, Integer page, Integer limit) {
		return Intent.findByApplicationId(applicationId, order, page, limit, context);
	}

	public Intent createCustomIntent(String applicationId, String name, String description, Map<String, String> extra) {
		return Intent.createCustomIntent(applicationId, name, description, extra, context);
	}

	public Intent createNoopIntent(String applicationId, String name, String description) {
		return Intent.createNoopIntent(applicationId, name, description, context);
	}

	public Intent createUrlIntent(String applicationId, String name, String description, String url) {
		return Intent.createUrlIntent(applicationId, name, description, url, context);
	}

	public Intent updateCustomIntent(String intentId, String name, String description, Map<String, String> extra) {
		return Intent.updateCustomIntent(intentId, name, description, extra, context);
	}

	public Intent updateNoopIntent(String intentId, String name, String description) {
		return Intent.updateNoopIntent(intentId, name, description, context);
	}

	public Intent updateUrlIntent(String intentId, String name, String description, String url) {
		return Intent.updateUrlIntent(intentId, name, description, url, context);
	}

	public void deleteIntent(String intentId) {
		Intent.delete(intentId, context);
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

	public Permission createPermissionByMail(String accountId, String targetMail, String resourceId, String actionId, String serviceId) {
		return Permission.createByMail(accountId, targetMail, resourceId, actionId, serviceId, context);
	}

	public void deletePermission(String accountId, String targetAccountId, String resourceId, String actionId) {
		Permission.delete(accountId, targetAccountId, resourceId, actionId, context);
	}

	public void deletePermissionByTargetAccountId(String deleterAccountId, String targetAccountId, String resourceId, String actionId) {
		Permission.deleteByTargetAccountId(deleterAccountId, targetAccountId, resourceId, actionId, context);
	}

	public boolean authorize(String resourceId, String actionId) {
		return Permission.authorize(resourceId, actionId, context);
	}

	public Plan findPlanByAccountId(String accountId) {
		return Plan.findByAccountId(accountId, context);
	}

	public RecoveryToken createRecoveryTokenAndSendMail(String mail) {
		return RecoveryToken.createAndSendMail(mail, context);
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

	public List<User> findByAccountIdAndApplicationId(String accountId, String applicationId) {
		return User.findByAccountIdAndApplicationId(accountId, applicationId, context);
	}

	public User createUser(String mail, String password, String name, String company, String phone) {
		return User.create(mail, password, name, company, phone, context);
	}

	public User createUserByAccountId(String accountId, String name, String mail, String password, String company, String phone,
			boolean createApplication) {
		return User.create(accountId, mail, password, name, company, phone, createApplication, context);
	}

	public User inviteUser(String mail, String password, String name, String company, String phone, String accountId, String resourceId,
			String actionId, String serviceId) {
		return User.invite(mail, password, name, company, phone, accountId, resourceId, actionId, serviceId, context);
	}

	public User updateUser(String accountId, String mail, String password, String company, String phone, Boolean subscription) {
		return User.update(accountId, mail, password, company, phone, subscription, context);
	}

	public List<GooglePartner> findGooglePartners() {
		return GooglePartner.find(context);
	}

	public List<GooglePartner> findGooglePartnerByGoogleId(String googleId) {
		return GooglePartner.findByGoogleId(googleId, context);
	}

}
