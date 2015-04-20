package com.growthbeat.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	public static <T> String sanitize(String json, Class<T> valueType) {
		return serialize(deserialize(json, valueType));
	}

	@SuppressWarnings("deprecation")
	public static String serialize(Object value) {

		// TODO beat, push に合わせたが、非推奨メソッドとなっていたので、後で対応
		ObjectMapper mapper = new ObjectMapper();
		mapper.getJsonFactory().setCharacterEscapes(new HTMLCharacterEscapes());

		String json = null;
		try {
			json = mapper.writeValueAsString(value);
		} catch (IOException e) {
			logger.debug("Serialization error. " + e.getMessage());
			return null;
		}
		return json;

	}

	public static <T> T deserialize(String json, Class<T> valueType) {

		if (json == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		T object = null;
		try {
			object = mapper.readValue(json, valueType);
		} catch (IOException e) {
			return null;
		}
		return object;

	}

	public static class HTMLCharacterEscapes extends CharacterEscapes {

		private static final long serialVersionUID = 1L;

		private final int[] asciiEscapes;

		public HTMLCharacterEscapes() {
			asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
			asciiEscapes['<'] = CharacterEscapes.ESCAPE_STANDARD;
			asciiEscapes['>'] = CharacterEscapes.ESCAPE_STANDARD;
			asciiEscapes['&'] = CharacterEscapes.ESCAPE_STANDARD;
			asciiEscapes['\''] = CharacterEscapes.ESCAPE_STANDARD;
			asciiEscapes['/'] = CharacterEscapes.ESCAPE_STANDARD;
			asciiEscapes['+'] = CharacterEscapes.ESCAPE_STANDARD;
		}

		@Override
		public int[] getEscapeCodesForAscii() {
			return asciiEscapes;
		}

		@Override
		public SerializableString getEscapeSequence(int ch) {
			return null;
		}
	}

}
