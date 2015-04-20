package com.growthbeat.model;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.utils.JsonUtils;

public class Model {

	public static final String ISO_8601_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";

	protected static <T> T get(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(get(context, path, params), valueType);
	}

	protected static <T> T get(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(get(context, path, params), valueTypeRef);
	}

	protected static <T> T post(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(post(context, path, params), valueType);
	}

	protected static <T> T post(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(post(context, path, params), valueTypeRef);
	}

	protected static <T> T put(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(put(context, path, params), valueType);
	}

	protected static <T> T put(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(put(context, path, params), valueTypeRef);
	}

	protected static <T> T delete(Context context, String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(delete(context, path, params), valueType);
	}

	protected static <T> T delete(Context context, String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(delete(context, path, params), valueTypeRef);
	}

	private static String get(Context context, String path, Map<String, Object> params) {
		addCredential(params, context);
		return context.getGrowthbeatHttpClient().get(path, params);
	}

	private static String post(Context context, String path, Map<String, Object> params) {
		addCredential(params, context);
		return context.getGrowthbeatHttpClient().post(path, params);
	}

	private static String put(Context context, String path, Map<String, Object> params) {
		addCredential(params, context);
		return context.getGrowthbeatHttpClient().put(path, params);
	}

	private static String delete(Context context, String path, Map<String, Object> params) {
		addCredential(params, context);
		return context.getGrowthbeatHttpClient().delete(path, params);
	}

	private static void addCredential(Map<String, Object> params, Context context) {
		params.put("credentialId", context.getCredentialId());
	}

}
