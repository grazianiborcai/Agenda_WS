package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.mind5.info.InfoSetterTemplate;


public final class SplitapaSetterResponseCancel extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {
		JsonElement json = toJson(recordInfo.responseBody);
		
		recordInfo = setTransaction(recordInfo, json);
		
		return recordInfo;
	}
	
	
	
	private SplitapaInfo setTransaction(SplitapaInfo recordInfo, JsonElement json) {
		Map<String, String> tran = new HashMap<>();
		JsonElement jtran = json.getAsJsonObject().get("last_transaction");		
		
		tran.put("id"     , jtran.getAsJsonObject().get("id").getAsString());
		tran.put("status" , jtran.getAsJsonObject().get("status").getAsString());
		tran.put("success", jtran.getAsJsonObject().get("success").getAsString());
		
		recordInfo.responseTransaction = tran;
		return recordInfo;		
	}
	
	
	
	private JsonElement toJson(String responseBody) {		
		return new JsonParser().parse(responseBody);
	}
}
