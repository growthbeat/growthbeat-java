package com.growthbeat.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.growthbeat.GrowthbeatException;

public class GrowthbeatHttpClient {

	private HttpClient httpClient = null;
	private String baseUrl = null;

	public GrowthbeatHttpClient() {
		super();
		this.httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.DEFAULT).build();
	}

	public GrowthbeatHttpClient(String baseUrl) {
		this();
		setBaseUrl(baseUrl);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String get(String path, Map<String, Object> params) {
		String query = URLEncodedUtils.format(convertNameValuePairs(params), Charset.defaultCharset());
		HttpGet httpGet = new HttpGet(String.format("%s%s%s", baseUrl, path, (query.isEmpty() ? "" : "?" + query)));
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
		HttpRequest httpRequest = new HttpRequest(String.format("%s%s", baseUrl, path));
		httpRequest.setMethod(method);
		httpRequest.setHeader("Accept", "application/json");
		httpRequest.setEntity(new UrlEncodedFormEntity(convertNameValuePairs(params), Consts.UTF_8));
		return request(httpRequest);
	}

	private List<NameValuePair> convertNameValuePairs(Map<String, Object> params) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet())
			nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
		return nameValuePairs;
	}

	private String request(final HttpUriRequest httpRequest) {

		String body = null;

		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getEntity() != null) {
				InputStream inputStream = httpResponse.getEntity().getContent();
				body = IOUtils.toString(inputStream);
			}
		} catch (IOException e) {
			throw new GrowthbeatException(e);
		} finally {
			try {
				if (httpResponse != null)
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
