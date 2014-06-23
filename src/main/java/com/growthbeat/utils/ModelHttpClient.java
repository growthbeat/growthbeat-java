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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.type.TypeReference;

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

	public <T> T get(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(get(version, api, params), valueType);
	}

	public <T> T get(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(get(version, api, params), valueTypeRef);
	}

	private String get(int version, String api, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		String query = URLEncodedUtils.format(parameters, Charset.defaultCharset());
		HttpGet httpGet = new HttpGet(String.format("%s%d/%s%s%s", baseUrl, version, api, query.isEmpty() ? "" : "?", query));
		httpGet.setHeader("Accept", "application/json");
		return request(httpGet);

	}

	public <T> T post(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(post(version, api, params), valueType);
	}

	public <T> T post(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(post(version, api, params), valueTypeRef);
	}

	private String post(int version, String api, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		HttpPost httpPost = new HttpPost(String.format("%s%d/%s", baseUrl, version, api));
		httpPost.setHeader("Accept", "application/json");
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
		}

		return request(httpPost);

	}

	public <T> T put(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(put(version, api, params), valueType);
	}

	public <T> T put(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(put(version, api, params), valueTypeRef);
	}

	private String put(int version, String api, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		String query = URLEncodedUtils.format(parameters, Charset.defaultCharset());
		HttpPut httpPut = new HttpPut(String.format("%s%d/%s%s%s", baseUrl, version, api, query.isEmpty() ? "" : "?", query));
		httpPut.setHeader("Accept", "application/json");

		return request(httpPut);

	}

	public <T> T delete(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(delete(version, api, params), valueType);
	}

	public <T> T delete(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(delete(version, api, params), valueTypeRef);
	}

	private String delete(int version, String api, Map<String, Object> params) {

		if (credentialSecret != null)
			params.put("secret", credentialSecret);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));

		String query = URLEncodedUtils.format(parameters, Charset.defaultCharset());
		HttpDelete httpDelete = new HttpDelete(String.format("%s%d/%s%s%s", baseUrl, version, api, query.isEmpty() ? "" : "?", query));
		httpDelete.setHeader("Accept", "application/json");

		return request(httpDelete);

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
