package com.growthbeat.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;

public class Connection extends Model {

	private String id;
	private Date created;
	private Account account;
	private Service service;
	private Account childAccount;

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

	public static Connection findByAccountIdAndServiceId(String accountId, String serviceId, Context context) {
		Map<String, Object> params = makeParams(context);
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		return get("1/connections", params, Connection.class);
	}

	public static List<Connection> findByAccountId(String accountId, Context context) {
		Map<String, Object> params = makeParams(context);
		params.put("accountId", accountId);
		return get("1/connections", params, new TypeReference<List<Connection>>() {
		});
	}

	public static Connection create(String accountId, String serviceId, Context context) {
		Map<String, Object> params = makeParams(context);
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		return post("1/connections", params, Connection.class);
	}

	public static void deleteByAccountIdAndServiceId(String accountId, String serviceId, Context context) {
		Map<String, Object> params = makeParams(context);
		params.put("accountId", accountId);
		params.put("serviceId", serviceId);
		delete("1/connections", params);
	}

}
