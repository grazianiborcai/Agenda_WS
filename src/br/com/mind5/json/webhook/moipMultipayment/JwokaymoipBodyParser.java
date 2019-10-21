package br.com.mind5.json.webhook.moipMultipayment;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.mind5.json.JsonBodyParserTemplate;


public class JwokaymoipBodyParser<T> extends JsonBodyParserTemplate<T> {
	
	public JwokaymoipBodyParser(Class<T> tClazz) {
		super(JwokaymoipBodyParser.class, tClazz);
	}
	
	
	
    @Override protected List<T> parseHook(String incomingData, Class<T> tClass) {
    	String sectionData = getSection(incomingData);    	
    	
		List<T> resultObjects = new ArrayList<>();
		Gson gson = new GsonBuilder().create();
		JsonParser parser = new JsonParser();
		

		if (parser.parse(sectionData).isJsonArray()) {
			JsonArray array = parser.parse(sectionData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				resultObjects.add(gson.fromJson(array.get(i), tClass));
			}
		} else {
			JsonObject object = parser.parse(sectionData).getAsJsonObject();
			resultObjects.add(gson.fromJson(object, tClass));
		}
		

		return resultObjects;
	}
    
    
    
    private String getSection(String incomingData) {
		JsonParser parser = new JsonParser();
		JsonObject object = parser.parse(incomingData).getAsJsonObject();		
		return object.getAsJsonObject("resource").get("payment").toString();
    }
}
