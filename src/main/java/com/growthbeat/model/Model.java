package com.growthbeat.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.http.HttpClient;
import com.growthbeat.http.JsonUtils;

public class Model {

	protected static Map<String, Object> makeParams(String credentialId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("credentialId", credentialId);
		return params;
	}

	static <T> T get(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(HttpClient.getInstance().get(path, params), valueType);
	}

	static <T> T get(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(HttpClient.getInstance().get(path, params), valueTypeRef);
	}

	static <T> T post(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(HttpClient.getInstance().post(path, params), valueType);
	}

	static <T> T post(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(HttpClient.getInstance().post(path, params), valueTypeRef);
	}

	static <T> T put(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(HttpClient.getInstance().put(path, params), valueType);
	}

	static <T> T put(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(HttpClient.getInstance().put(path, params), valueTypeRef);
	}

	static <T> T delete(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(HttpClient.getInstance().delete(path, params), valueType);
	}

	static <T> T delete(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(HttpClient.getInstance().delete(path, params), valueTypeRef);
	}

}
