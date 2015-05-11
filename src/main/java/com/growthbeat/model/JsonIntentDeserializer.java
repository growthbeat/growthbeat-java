package com.growthbeat.model;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.growthbeat.utils.JsonUtils;

public class JsonIntentDeserializer extends JsonDeserializer<Intent> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Intent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jp.getCodec();
		Map<String, Object> map = objectCodec.readValue(jp, new TypeReference<Map<String, Object>>() {
		});
		String json = JsonUtils.serialize(map);

		if (!map.containsKey("type") || map.get("type") == null)
			return null;

		IntentType type = null;
		try {
			type = IntentType.valueOf((String) map.get("type"));
		} catch (IllegalArgumentException e) {
			logger.warn("Invalid intent type: " + e.getMessage());
			return null;
		}

		switch (type) {
		case custom:
			return JsonUtils.deserialize(json, CustomIntent.class);
		case noop:
			return JsonUtils.deserialize(json, NoopIntent.class);
		case url:
			return JsonUtils.deserialize(json, UrlIntent.class);
		default:
			logger.warn("Invalid intent type: null");
			return null;
		}

	}
}
