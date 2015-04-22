package com.growthbeat.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static <T> String sanitize(String json, Class<T> valueType) {
		return serialize(deserialize(json, valueType));
	}

	public static String serialize(Object value) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

		String json = null;
		try {
			json = mapper.writeValueAsString(value);
		} catch (IOException e) {
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
