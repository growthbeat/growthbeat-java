package com.growthbeat.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.http.GrowthbeatHttpClient;
import com.growthbeat.http.JsonUtils;

public class Model {

	private static GrowthbeatHttpClient growthbeatHttpClient = new GrowthbeatHttpClient();

	protected static Map<String, Object> makeParams(String credentialId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("credentialId", credentialId);
		return params;
	}

	static void get(String path, Map<String, Object> params) {
		growthbeatHttpClient.get(path, params);
	}

	static <T> T get(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(growthbeatHttpClient.get(path, params), valueType);
	}

	static <T> T get(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(growthbeatHttpClient.get(path, params), valueTypeRef);
	}

	static void post(String path, Map<String, Object> params) {
		growthbeatHttpClient.post(path, params);
	}

	static <T> T post(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(growthbeatHttpClient.post(path, params), valueType);
	}

	static <T> T post(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(growthbeatHttpClient.post(path, params), valueTypeRef);
	}

	static void put(String path, Map<String, Object> params) {
		growthbeatHttpClient.put(path, params);
	}

	static <T> T put(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(growthbeatHttpClient.put(path, params), valueType);
	}

	static <T> T put(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(growthbeatHttpClient.put(path, params), valueTypeRef);
	}

	static void delete(String path, Map<String, Object> params) {
		growthbeatHttpClient.delete(path, params);
	}

	static <T> T delete(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(growthbeatHttpClient.delete(path, params), valueType);
	}

	static <T> T delete(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(growthbeatHttpClient.delete(path, params), valueTypeRef);
	}

}
