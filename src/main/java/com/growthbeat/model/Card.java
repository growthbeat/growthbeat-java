package com.growthbeat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Card extends Model {

	private String id;
	private String last4;
	private Date created;
	private Account account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLast4() {
		return last4;
	}

	public void setLast4(String last4) {
		this.last4 = last4;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_8601_DATETIME_FORMAT)
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

}
