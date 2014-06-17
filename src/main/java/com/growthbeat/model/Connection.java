package com.growthbeat.model;

import java.util.Date;

public class Connection extends Model {

	private Date created;
	private Application application;
	private Service service;
	private Account account;
	private Account childAccount;
	private Credential credential;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getChildAccount() {
		return childAccount;
	}

	public void setChildAccount(Account childAccount) {
		this.childAccount = childAccount;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}
