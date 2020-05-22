package com.s4n.delivery.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private final ObjectMapper objectMapper;
	private static JsonUtil jsonUtil;

	private JsonUtil() {
		objectMapper = new ObjectMapper();
	}
	
	public static JsonUtil getInstance() {
		if(jsonUtil == null) {
			jsonUtil = new JsonUtil();
		}
		return jsonUtil;
	}

	public <T> T unmarshall(final String json, final Class<T> myClass) {
		T object = null;
		try {
			object = objectMapper.readValue(json, myClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}	
	
	public <T> List<T> convertJsonToList(String jsonPath, final Class<T> myClass) {
		JSONArray array = readJsonListFromFile(jsonPath);
		return IntStream.range(0, array.size()).mapToObj(i -> {
			try {
				return unmarshall(array.get(i).toString(), myClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}
	
	private JSONArray readJsonListFromFile(String path) {
		Object obj = new Object();
		try {
			obj = new JSONParser().parse(new FileReader(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) obj;
	}

}
