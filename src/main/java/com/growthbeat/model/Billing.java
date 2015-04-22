package com.growthbeat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.growthbeat.constants.Constants;

public class Billing extends Model {

	private Date created;
	private Account account;
	private Account targetAccount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
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

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

}
