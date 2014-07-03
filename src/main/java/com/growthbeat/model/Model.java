package com.growthbeat.model;

import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.utils.JsonUtils;
import com.growthbeat.utils.ModelHttpClient;

public class Model {

	static <T> T get(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().get(path, params), valueType);
	}

	static <T> T get(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().get(path, params), valueTypeRef);
	}

	static <T> T post(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().post(path, params), valueType);
	}

	static <T> T post(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().post(path, params), valueTypeRef);
	}

	static <T> T put(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().put(path, params), valueType);
	}

	static <T> T put(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().put(path, params), valueTypeRef);
	}

	static <T> T delete(String path, Map<String, Object> params, Class<T> valueType) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().delete(path, params), valueType);
	}

	static <T> T delete(String path, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return JsonUtils.deserialize(ModelHttpClient.getInstance().delete(path, params), valueTypeRef);
	}

}
