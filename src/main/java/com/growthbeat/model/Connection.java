package com.growthbeat.model;

import java.util.Date;

public class Connection extends Model {

	private String id;
	private Date created;
	private Account account;
	private Service service;
	private Account childAccount;
	private Credential credential;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
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
