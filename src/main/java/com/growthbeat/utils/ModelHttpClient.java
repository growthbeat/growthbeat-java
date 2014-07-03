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
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class ModelHttpClient {

	private final HttpClient httpClient = new DefaultHttpClient();
	private static String baseUrl = "http://api.localhost:8085/";
	private static String credentialSecret = null;

	private static ModelHttpClient instance = new ModelHttpClient();

	public static ModelHttpClient getInstance() {
		return instance;
	}

	public static void setBaseUrl(String baseUrl) {
		ModelHttpClient.baseUrl = baseUrl;
	}

	public static void setCredentialSecret(String credentialSecret) {
		ModelHttpClient.credentialSecret = credentialSecret;
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

		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
		} catch (IOException e) {
			// TODO 例外処理
		}

		String body = null;
		try {
			InputStream inputStream = httpResponse.getEntity().getContent();
			body = IOUtils.toString(inputStream);
		} catch (IOException e) {
			// TODO 例外処理
		} finally {
			try {
				httpResponse.getEntity().consumeContent();
			} catch (IOException e) {
				// TODO 例外処理
			}
		}

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode < 200 || statusCode >= 300) {
			// TODO 例外処理
		}

		return body;

	}

}
