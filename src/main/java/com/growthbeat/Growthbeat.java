package com.growthbeat;

import java.util.List;

import com.growthbeat.model.Account;
import com.growthbeat.model.Action;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Connection;
import com.growthbeat.model.Credential;
import com.growthbeat.model.Order;
import com.growthbeat.model.Permission;
import com.growthbeat.model.Resource;
import com.growthbeat.model.Service;
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

	public void deleteApplicationById(String id) {
		Application.deleteById(id, context);
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

	public void deleteClientById(String id) {
		Client.deleteById(id, context);
	}

	public Connection findConnectionByAccountIdAndServiceId(String accountId, String serviceId) {
		return Connection.findByAccountIdAndServiceId(accountId, serviceId, context);
	}

	public List<Connection> findConnectionByAccountId(String accountId) {
		return Connection.findByAccountId(accountId, context);
	}

	public Connection createConnection(String accountId, String serviceId) {
		return Connection.create(accountId, serviceId, context);
	}

	public void deleteConnectionByAccountIdAndServiceId(String accountId, String serviceId) {
		Connection.deleteByAccountIdAndServiceId(accountId, serviceId, context);
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

	public void deleteCredentialById(String id) {
		Credential.deleteById(id, context);
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

	public boolean authorize(String accountId, String resourceId, String actionId) {
		return Permission.authorize(accountId, resourceId, actionId, context);
	}

	public Resource findResourceById(String id) {
		return Resource.findById(id, context);
	}

	public Resource createResource(String parentResourceId, String name) {
		return Resource.create(parentResourceId, name, context);
	}

	public void deleteResourceById(String id) {
		Resource.deleteById(id, context);
	}

	public Service findServiceById(String id) {
		return Service.findById(id, context);
	}

	public List<Service> findServiceByAccountId(String accountId) {
		return Service.findByAccountId(accountId, context);
	}

	public Service createService(String name, String namespace, String url, String domain) {
		return Service.create(name, namespace, url, domain, context);
	}

	public void deleteServiceById(String id) {
		Service.deleteById(id, context);
	}

	public Session findSessionById(String id) {
		return Session.findById(id, context);
	}

	public Session createSession(String accountId, String serviceId) {
		return Session.create(accountId, serviceId, context);
	}

	public void deleteSessionById(String id) {
		Session.deleteById(id, context);
	}

	public User findUserByAccountId(String accountId) {
		return User.findByAccountId(accountId, context);
	}

	public User createUser(String accountId, String mail, String password) {
		return User.create(accountId, mail, password, context);
	}

	public User createUser(String mail, String password) {
		return User.create(mail, password, context);
	}

	public User updateUserMail(String accountId, String mail) {
		return User.updateMail(accountId, mail, context);
	}

	public User updateUserPassword(String accountId, String currentPassword, String password) {
		return User.updatePassword(accountId, currentPassword, password, context);
	}

	public void deleteUserByAccountId(String accountId) {
		User.deleteByAccountId(accountId, context);
	}

}
