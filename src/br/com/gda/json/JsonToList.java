package br.com.gda.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonToList<T> {
	private final Class<T> tClass;
	
	public JsonToList(Class<T> tClass) {
		this.tClass = tClass;
	}
	
	
	public List<T> parse(String incomingData) {
		List<T> resultObjects = new ArrayList<>();
		Gson gson = new GsonBuilder().setExclusionStrategies(new JsonAttrExclusion()).create();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				resultObjects.add(gson.fromJson(array.get(i), this.tClass));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			resultObjects.add(gson.fromJson(object, this.tClass));
		}

		return resultObjects;
	}
}
