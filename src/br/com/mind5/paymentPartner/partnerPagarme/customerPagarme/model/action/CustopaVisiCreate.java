package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.JsonBuilder;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class CustopaVisiCreate extends ActionVisitorTemplateSimple<CustopaInfo> {
	
	public CustopaVisiCreate(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CustopaInfo> executeTransformationHook(List<CustopaInfo> baseInfos) {	
		List<CustopaInfo> results = new ArrayList<>();		
		
		for(CustopaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = createCustomer(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod.responseBody = response.getBody();
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createCustomer(CustopaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		
		HttpResponse<String> response = tryToCreateCustomer(body, authorization);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();

		builder.addBuilderToJson(makeBodyRoot(recordInfo));
		builder.addBuilderToJson(makeBodyMetadata(recordInfo));
		builder.addBuilderToJson(makeBodyPhone(recordInfo));
		builder.addBuilderToJson(makeBodyAddress(recordInfo));
		
		return builder.build();
	}
	
	
	
	private JsonBuilder makeBodyRoot(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("name"         , recordInfo.name);
		builder.addObjToJson("email"        , recordInfo.email);
		builder.addObjToJson("code"         , recordInfo.code);
		builder.addObjToJson("type"         , recordInfo.type);
		builder.addObjToJson("gender"       , recordInfo.gender);
		builder.addObjToJson("document"     , recordInfo.document);
		builder.addObjToJson("birthdate"    , recordInfo.birthdate);
		builder.addObjToJson("document_type", recordInfo.documentType);
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyPhone(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		JsonBuilder temp    = new JsonBuilder();
		
		temp.addBuilderToJson(makeBodyPhoneHome(recordInfo));
		temp.addBuilderToJson(makeBodyPhoneMobile(recordInfo));
		
		builder.addBuilderToJson("phones", temp);
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyPhoneMobile(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		if (recordInfo.mobilePhone == null)
			return builder;
		
		builder.addNestedObjToJson("mobile_phone", recordInfo.mobilePhone);		
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyPhoneHome(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		if (recordInfo.homePhone == null)
			return builder;
		
		builder.addNestedObjToJson("mobile_phone", recordInfo.homePhone);		
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyAddress(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		if (recordInfo.address == null)
			return builder;
		
		builder.addNestedObjToJson("address", recordInfo.address);		
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyMetadata(CustopaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		Map<String,String> meta = new HashMap<>();
		
		meta.put("codPayCustomer", recordInfo.compoundId);
		builder.addNestedObjToJson("metadata", meta);		
		
		return builder;
	}	
	
	
	
	private String makeAuthorization(CustopaInfo recordInfo) {
		return recordInfo.authorization;
	}
	
	
	
	private HttpResponse<String> tryToCreateCustomer(String body, String authorization) {
		try {
			return Unirest.post("https://api.pagar.me/core/v5/customers")
					  	  .header("accept", "application/json")
						  .header("content-type", "application/json")
						  .header("authorization", authorization)
						  .body(body)
						  .asString();
			
			
		} catch (Exception e) {
			super.logException(e);
			return null;
		}
	}
	
	
	
	private boolean hasError(HttpResponse<String> response) {
		if (response == null)
			return true;
		
		if (response.getStatus() == 200)
			return false;
		
		return true;
	}
	
	
	
	private void writeLogOnError(HttpResponse<String> response) {
		if (response == null)
			return;
		
		System.out.println(response.getBody());
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAGARME_CUSTOMER_CREATION_ERROR;
	}
}
