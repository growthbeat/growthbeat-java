package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;

public class Service extends Model {

	private String id;
	private String name;
	private String namespace;
	private String secret;
	private String url;
	private String domain;
	private Date created;
	private Account account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
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

	public static Service findById(String id, Context context) {
		return get(context, String.format("1/services/%s", id), new HashMap<String, Object>(), Service.class);
	}

	public static List<Service> findByAccountId(String accountId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return get(context, "1/services", params, new TypeReference<List<Service>>() {
		});
	}

	public static Service create(String name, String namespace, String url, String domain, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("namespace", namespace);
		params.put("url", url);
		params.put("domain", domain);
		return post(context, "1/services", params, Service.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/services/%s", id), new HashMap<String, Object>(), Void.class);
	}

}
