package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.mind5.info.InfoSetterTemplate;


public final class CustopaSetterResponseAttr extends InfoSetterTemplate<CustopaInfo> {
	
	@Override protected CustopaInfo setAttrHook(CustopaInfo recordInfo) {
		JsonElement json = toJson(recordInfo.responseBody);
		
		recordInfo = setRootAttr(recordInfo, json);
		
		return recordInfo;
	}
	
	
	
	private CustopaInfo setRootAttr(CustopaInfo recordInfo, JsonElement json) {
		recordInfo.id = json.getAsJsonObject().get("id").getAsString();
		return recordInfo;
	}
	
	
	
	private JsonElement toJson(String responseBody) {		
		return new JsonParser().parse(responseBody);
	}
}
