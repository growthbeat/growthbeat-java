package com.growthbeat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.growthbeat.GrowthbeatException;

public class HttpClient {

	private static HttpClient instance = new HttpClient();

	private org.apache.http.client.HttpClient httpClient = null;
	private String baseUrl = "http://api.localhost:8085/";
	private String credentialSecret = null;

	private HttpClient() {
		super();
		this.httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.DEFAULT).build();
	}

	public static HttpClient getInstance() {
		return instance;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setCredentialSecret(String credentialSecret) {
		this.credentialSecret = credentialSecret;
	}

	public String get(String path, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		String query = URLEncodedUtils.format(parameters, Charset.defaultCharset());
		HttpGet httpGet = new HttpGet(String.format("%s%s%s%s", baseUrl, path, query.isEmpty() ? "" : "?", query));
		httpGet.setHeader("Accept", "application/json");
		return request(httpGet);

	}

	public String post(String path, Map<String, Object> params) {
		return request("POST", path, params);
	}

	public String put(String path, Map<String, Object> params) {
		return request("PUT", path, params);
	}

	public String delete(String path, Map<String, Object> params) {
		return request("DELETE", path, params);
	}

	private String request(String method, String path, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		HttpRequest httpRequest = new HttpRequest(String.format("%s%s", baseUrl, path));
		httpRequest.setMethod(method);
		httpRequest.setHeader("Accept", "application/json");
		try {
			httpRequest.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
		}

		return request(httpRequest);

	}

	private String request(final HttpUriRequest httpRequest) {

		String body = null;

		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
			InputStream inputStream = httpResponse.getEntity().getContent();
			body = IOUtils.toString(inputStream);
		} catch (IOException e) {
			throw new GrowthbeatException(e);
		} finally {
			try {
				EntityUtils.consume(httpResponse.getEntity());
			} catch (IOException e) {
			}
		}

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode < 200 || statusCode >= 300)
			throw new GrowthbeatException("Invalid status code: " + statusCode);

		return body;

	}
}
