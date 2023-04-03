package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.mind5.info.InfoSetterTemplate;


public final class OrdapaSetterResponseCreate extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {
		JsonElement json = toJson(recordInfo.responseBody);
		
		recordInfo = setRootAttr(recordInfo, json);
		recordInfo = setItems(recordInfo, json);
		recordInfo = setCharges(recordInfo, json);
		
		return recordInfo;
	}
	
	
	
	private OrdapaInfo setRootAttr(OrdapaInfo recordInfo, JsonElement json) {
		Map<String, String> root = new HashMap<>();
		
		root.put("id"      , json.getAsJsonObject().get("id").getAsString());
		root.put("code"    , json.getAsJsonObject().get("code").getAsString());
		root.put("status"  , json.getAsJsonObject().get("status").getAsString());
		root.put("amount"  , json.getAsJsonObject().get("amount").getAsString());		
		root.put("closed"  , json.getAsJsonObject().get("closed").getAsString());
		root.put("currency", json.getAsJsonObject().get("currency").getAsString());

		recordInfo.responseRoot = root;		
		return recordInfo;
	}
	
	
	
	private OrdapaInfo setItems(OrdapaInfo recordInfo, JsonElement json) {
		JsonArray jarray = json.getAsJsonObject().get("items").getAsJsonArray();
		
		
		for (int i = 0; i < jarray.size(); i++) {
			Map<String, String> eachItem = new HashMap<>();
			JsonObject jobj = jarray.get(i).getAsJsonObject();
			
			for (Entry<String, JsonElement> eachEntry : jobj.entrySet()) {				
				eachItem.put(eachEntry.getKey(), eachEntry.getValue().getAsString());		
			}			
			
			recordInfo.responseItems.add(eachItem);
		}
		
		
		return recordInfo;		
	}
	
	
	
	private OrdapaInfo setCharges(OrdapaInfo recordInfo, JsonElement json) {
		JsonArray jarray = json.getAsJsonObject().get("charges").getAsJsonArray();		
		
		for (int i = 0; i < jarray.size(); i++) {
			Map<String, String> eachItem = new HashMap<>();
			JsonObject jobj = jarray.get(i).getAsJsonObject();
			
			for (Entry<String, JsonElement> eachEntry : jobj.entrySet()) {				
				if (eachEntry.getKey().equals("id"))
					eachItem.put("charge_id", eachEntry.getValue().getAsString());
				
				if (eachEntry.getKey().equals("last_transaction")) {
					JsonObject jtran = eachEntry.getValue().getAsJsonObject();					
					eachItem.put("transaction_id"     , jtran.get("id").getAsString());
					eachItem.put("transaction_status" , jtran.get("status").getAsString());
					eachItem.put("transaction_success", jtran.get("success").getAsString());
				}
			}			
			recordInfo.responseCharges.add(eachItem);
		}
		
		
		return recordInfo;		
	}
	
	
	
	private JsonElement toJson(String responseBody) {		
		return new JsonParser().parse(responseBody);
	}
}
