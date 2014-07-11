package com.growthbeat.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.Context;
import com.growthbeat.http.JsonUtils;

public class Model {

	protected static Map<String, Object> makeParams(Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("credentialId", context.getCredentialId());
		return params;
	}

	static void get(Context context, String path, Map<String, Object> params) {
		context.getGrowthbeatHttpClient().get(path, params);
	}

	static <T> T get(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().get(path, params), valueType);
	}

	static <T> T get(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().get(path, params), valueTypeRef);
	}

	static void post(Context context, String path, Map<String, Object> params) {
		context.getGrowthbeatHttpClient().post(path, params);
	}

	static <T> T post(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().post(path, params), valueType);
	}

	static <T> T post(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().post(path, params), valueTypeRef);
	}

	static void put(Context context, String path, Map<String, Object> params) {
		context.getGrowthbeatHttpClient().put(path, params);
	}

	static <T> T put(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().put(path, params), valueType);
	}

	static <T> T put(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().put(path, params), valueTypeRef);
	}

	static void delete(Context context, String path, Map<String, Object> params) {
		context.getGrowthbeatHttpClient().delete(path, params);
	}

	static <T> T delete(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().delete(path, params), valueType);
	}

	static <T> T delete(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(context.getGrowthbeatHttpClient().delete(path, params), valueTypeRef);
	}

}
