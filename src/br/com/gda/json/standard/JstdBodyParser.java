package br.com.gda.json.standard;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.gda.json.JsonBodyParserTemplate;


public class JstdBodyParser<T> extends JsonBodyParserTemplate<T> {
	
	public JstdBodyParser(Class<T> tClazz) {
		super(JstdBodyParser.class, tClazz);
	}
	
	
	
    @Override protected List<T> parseHook(String incomingData, Class<T> tClass) {
		List<T> resultObjects = new ArrayList<>();
		Gson gson = new GsonBuilder().setExclusionStrategies(new JstdAttrExclusion()).create();
		JsonParser parser = new JsonParser();
		

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				resultObjects.add(gson.fromJson(array.get(i), tClass));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			resultObjects.add(gson.fromJson(object, tClass));
		}
		

		return resultObjects;
	}
}
