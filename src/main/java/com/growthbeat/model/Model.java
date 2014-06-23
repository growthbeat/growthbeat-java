package com.growthbeat.model;

import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

import com.growthbeat.utils.ModelHttpClient;

public class Model {

	static <T> T get(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return ModelHttpClient.getInstance().get(version, api, params, valueType);
	}

	static <T> T get(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return ModelHttpClient.getInstance().get(version, api, params, valueTypeRef);
	}

	static <T> T post(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return ModelHttpClient.getInstance().post(version, api, params, valueType);
	}

	static <T> T post(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return ModelHttpClient.getInstance().post(version, api, params, valueTypeRef);
	}

	static <T> T put(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return ModelHttpClient.getInstance().put(version, api, params, valueType);
	}

	static <T> T put(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return ModelHttpClient.getInstance().put(version, api, params, valueTypeRef);
	}

	static <T> T delete(int version, String api, Map<String, Object> params, Class<T> valueType) {
		return ModelHttpClient.getInstance().delete(version, api, params, valueType);
	}

	static <T> T delete(int version, String api, Map<String, Object> params, TypeReference<T> valueTypeRef) {
		return ModelHttpClient.getInstance().delete(version, api, params, valueTypeRef);
	}

}
