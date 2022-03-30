package com.pablojuice.task_5;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;

public abstract class JSONModel<T> {
	private static ObjectMapper mapper;

	public JSONObject asJson() {
		try {
			return new JSONObject(getObjectMapper().writeValueAsString(this));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject();
	}

	public ObjectMapper getObjectMapper() {
		if (mapper == null) {
			mapper = setupMapper();
		}
		return mapper;
	}

	public ObjectMapper setupMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(JsonMethod.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		return objectMapper;
	}

	public <T> T parseJsonFromString(Class<T> clazz, String jsonString){
		try {
			return getObjectMapper().readValue(jsonString, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
