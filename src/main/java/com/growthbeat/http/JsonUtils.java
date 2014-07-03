package com.growthbeat.http;

import java.io.IOException;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {

	public static <T> T deserialize(String json, Class<T> valueType) {

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

	public static <T> T deserialize(String json, TypeReference<T> valueType) {

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
