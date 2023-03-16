package br.com.mind5.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonBuilder {
	private StringBuilder jsonBuilder;
	
	
	public JsonBuilder() {
		super();
	}
	
	
	
	public JsonBuilder addArrayToJson(String ojbName, List<Map<String,String>> obj) {
		String ojbNameStr = parseObjStr(ojbName);
		List<Map<String,String>> ojbArray = parseObjArray(obj);
		
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append("\"").append(ojbNameStr).append("\":");
		jsonTemp.append(arrayToJson(ojbArray));		
		
		return add(jsonTemp.toString());
	}
	
	
	
	public JsonBuilder addArrayToJson(String ojbName, String obj) {
		String ojbNameStr = parseObjStr(ojbName);
		String ojbArray = parseObjStr(obj);
		
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append("\"").append(ojbNameStr).append("\":");
		jsonTemp.append("[").append(ojbArray).append("]");
		
		return add(jsonTemp.toString());
	}
	
	
	
	public JsonBuilder addBuilderToJson(JsonBuilder obj) {
		JsonBuilder ojbBuilder = parseObjBuilder(obj);		
		return add(ojbBuilder.buildWithoutBraces());
	}
	
	
	
	public JsonBuilder addBuilderToJson(String ojbName, JsonBuilder obj) {
		String ojbNameStr = parseObjStr(ojbName);
		JsonBuilder ojbBuilder = parseObjBuilder(obj);
		
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append("\"").append(ojbNameStr).append("\":");
		jsonTemp.append("{").append(ojbBuilder.buildWithoutBraces()).append("}");
		
		return add(jsonTemp.toString());
	}
	
	
	
	public JsonBuilder addStrToJson(String obj) {
		String ojbStr = parseObjStr(obj);		
		return add(ojbStr);
	}
	
	
	
	public JsonBuilder addObjToJson(Map<String, String> obj) {
		Map<String, String> ojbMap = parseObjMap(obj);
		
		for (Map.Entry<String, String> entry : ojbMap.entrySet()) {
			addObjToJson(entry.getKey(), entry.getValue());
		}
		
		return this;
	}
	
	
	
	public JsonBuilder addObjToJson(String key, String value) {
		String keyStr = parseObjStr(key);
		String valueStr = parseObjStr(value);
		
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append("\"").append(keyStr).append("\":");
		jsonTemp.append("\"").append(valueStr).append("\"");
		
		return add(jsonTemp.toString());
	}
	
	
	
	public JsonBuilder addNestedObjToJson(String ojbName, String key, String value) {
		Map<String, String> map = new HashMap<>();
		map.put(key, value);
		
		return addNestedObjToJson(ojbName, map);
	}
	
	
	
	public JsonBuilder addNestedObjToJson(String ojbName, Map<String, String> obj) {
		String ojbNameStr = parseObjStr(ojbName);
		Map<String, String> ojbMap = parseObjMap(obj);

		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append("\"").append(ojbNameStr).append("\":");
		jsonTemp.append("{").append(mapToJson(ojbMap)).append("}");
		
		return add(jsonTemp.toString());
	}
	
	
	
	public String build() {
		if (jsonBuilder == null)
			 return buildEmptyJson();
		
		return buildJsonWithBraces();
	}
	
	
	
	public String buildWithoutBraces() {
		if (jsonBuilder == null)
			 return buildEmptyJson();
		
		return jsonBuilder.toString();
	}
	
	
	
	public void reset() {
		jsonBuilder = null;
	}
	
	
	
	private String arrayToJson(List<Map<String,String>> obj) {
		List<Map<String,String>> ojbArray = parseObjArray(obj);		
		int semaphore = 0;
		
		StringBuilder jsonTemp = new StringBuilder();
		jsonTemp.append("[");
		
		
		for (Map<String,String> eachObj : ojbArray) {
			if (semaphore != 0)
				jsonTemp.append(",");
			
			jsonTemp.append("{");
			jsonTemp.append(mapToJson(eachObj));
			jsonTemp.append("}");
			semaphore = 1;
		}

		
		jsonTemp.append("]");
		return jsonTemp.toString();
	}

	
		
	private String mapToJson(Map<String, String> map) {
		Map<String, String> ojbMap = parseObjMap(map);

		StringBuilder jsonTemp = new StringBuilder();
		int semaphore = 0;
		
		for (Map.Entry<String, String> entry : ojbMap.entrySet()) {
			if (semaphore != 0)
				jsonTemp.append(",");
			
			jsonTemp.append("\"").append(entry.getKey()).append("\":").append("\"").append(entry.getValue()).append("\"");			
			semaphore = 1;
		}
		
		return jsonTemp.toString();
	}
	
	
	
	private String buildEmptyJson() {
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append(getStartOfJson());
		jsonTemp.append(getEndOfJson());
		
		return jsonTemp.toString();
	}
	
	
	
	private String buildJsonWithBraces() {
		StringBuilder jsonTemp = new StringBuilder();
		
		jsonTemp.append(getStartOfJson());
		jsonTemp.append(jsonBuilder.toString());
		jsonTemp.append(getEndOfJson());
		
		return jsonTemp.toString();
	}
	
	
	
	private JsonBuilder add(String str) {
		if (jsonBuilder == null) 
			return addWithInit(str);
		
		return addWithComma(str);
	}
	
	
	
	private JsonBuilder addWithInit(String str) {
		jsonBuilder = new StringBuilder();

		jsonBuilder.append(str);		
		return this;
	}
	
	
	
	private JsonBuilder addWithComma(String str) {
		jsonBuilder.append(",");
		jsonBuilder.append(str);
		
		return this;
	}
	
	
	
	private String getStartOfJson() {		
		return "{";
	}
	
	
	
	private String getEndOfJson() {		
		return "}";
	}
	
	
	
	private Map<String,String> parseObjMap(Map<String,String> objMap) {
		if(objMap == null) 
			return getNullObj();
		
		if(objMap.size() == 0) 
			return getNullObj();
			
		return objMap;
	}
	
	
	
	private List<Map<String,String>> parseObjArray(List<Map<String,String>> objArray) {
		if(objArray == null) 
			return getNullObjArray();
			
		return objArray;
	}
	
	
	
	private String parseObjStr(String objStr) {
		if(objStr == null) 
			return getNullObjName();
			
		return objStr;
	}
	
	
	
	private JsonBuilder parseObjBuilder(JsonBuilder objBuilder) {
		if(objBuilder == null) 
			return getNullObjBuilder();
			
		return objBuilder;
	}
	
	
	
	private List<Map<String,String>> getNullObjArray() {
		List<Map<String,String>> objArray = new ArrayList<>();
		
		objArray.add(getNullObj());
		return objArray;
	}
	
	
	
	private Map<String,String> getNullObj() {
		Map<String, String> map = new HashMap<>();
		
		map.put("", "");		
		return map;
	}
	
	
	
	private String getNullObjName() {
		return "";
	}
	
	
	
	private JsonBuilder getNullObjBuilder() {
		JsonBuilder objBuilder = new JsonBuilder();
		
		objBuilder.add(null);
		return objBuilder;
	}
}
