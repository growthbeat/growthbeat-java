package com.growthbeat.model;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Model {

	private static final HttpClient httpClient = new DefaultHttpClient();
	private static String baseUrl = "http://api.localhost:8085/";
	private static String credentialSecret = null;

	public static void setBaseUrl(String baseUrl) {
		Model.baseUrl = baseUrl;
	}

	public static void setCredentialSecret(String credentialSecret) {
		Model.credentialSecret = credentialSecret;
	}

	static <T> T get(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return deserialize(get(version, api, params), valueType);
	}

	static <T> T get(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return deserialize(get(version, api, params), valueTypeRef);
	}

	private static String get(int version, String api, Map<String, Object> params) {

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

	static <T> T post(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return deserialize(post(version, api, params), valueType);
	}

	static <T> T post(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return deserialize(post(version, api, params), valueTypeRef);
	}

	private static String post(int version, String api, Map<String, Object> params) {

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

	private static String request(final HttpUriRequest httpRequest) {

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

	static <T> T deserialize(String json, Class<T> valueType) {

		if (json == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		T object = null;
		try {
			object = mapper.readValue(json, valueType);
		} catch (IOException e) {
			return null;
		}
		return object;

	}

	static <T> T deserialize(String json, TypeReference<T> valueType) {

		if (json == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		T object = null;
		try {
			object = mapper.readValue(json, valueType);
		} catch (IOException e) {
			return null;
		}
		return object;

	}
}
