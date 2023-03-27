package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.JsonBuilder;
import br.com.mind5.common.SystemCode;
import br.com.mind5.json.standard.JstdBodyParser;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class CrecapaVisiCreate extends ActionVisitorTemplateSimple<CrecapaInfo> {
	
	public CrecapaVisiCreate(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CrecapaInfo> executeTransformationHook(List<CrecapaInfo> baseInfos) {	
		List<CrecapaInfo> results = new ArrayList<>();
		
		
		for(CrecapaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = createCard(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createCard(CrecapaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		String url = makeUrl(recordInfo);
		
		HttpResponse<String> response = tryToCreateCard(body, authorization, url);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(CrecapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();

		builder.addBuilderToJson(makeBodyCreditCard(recordInfo));
		builder.addBuilderToJson(makeBodyMetadata(recordInfo));
		builder.addBuilderToJson(makeBodyBillingAddress(recordInfo));
		
		return builder.build();
	}
	
	
	
	private JsonBuilder makeBodyCreditCard(CrecapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("customer_id"    , recordInfo.customerId);
		builder.addObjToJson("number"         , recordInfo.cardNumber);
		builder.addObjToJson("holder_name"    , recordInfo.nameHolder);
		builder.addObjToJson("holder_document", recordInfo.cpfHolder);
		builder.addObjToJson("exp_month"      , recordInfo.expirationMonth);
		builder.addObjToJson("exp_year"       , recordInfo.expirationYear);
		builder.addObjToJson("cvv"    		  , recordInfo.cardCvc);
		builder.addObjToJson("brand"          , recordInfo.creditCardBrand);		
		builder.addObjToJson("label"          , recordInfo.label);
		builder.addObjToJson("options"        , recordInfo.options);
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyMetadata(CrecapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		Map<String,String> meta = new HashMap<>();
		
		meta.put("codCreditCard", recordInfo.metadataId);
		builder.addNestedObjToJson("metadata", meta);		
		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyBillingAddress(CrecapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		if (recordInfo.billingAddress == null)
			return builder;
		
		builder.addNestedObjToJson("billing_address", recordInfo.billingAddress);		
		
		return builder;
	}
	
	
	
	private String makeAuthorization(CrecapaInfo recordInfo) {
		return recordInfo.authorization;
	}
	
	
	
	private String makeUrl(CrecapaInfo recordInfo) {
		return "https://api.pagar.me/core/v5/customers/" + recordInfo.customerId + "/cards";
	}
	
	
	
	private HttpResponse<String> tryToCreateCard(String body, String authorization, String url) {
		try {
			return Unirest.post(url)
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
	
	
	
	private CrecapaInfo setAttribute(CrecapaInfo recordInfo, HttpResponse<String> response) {
		CrecapaInfo parsedResponse = parseResponse(response);	
		
		recordInfo.id = parsedResponse.id;
		recordInfo.last_four_digits = parsedResponse.last_four_digits;
		recordInfo.brand = parsedResponse.brand;
		
		return recordInfo;
	}
	
	
	
	private CrecapaInfo parseResponse(HttpResponse<String> response) {
		JstdBodyParser<CrecapaInfo> parser = new JstdBodyParser<>(CrecapaInfo.class);		
		List<CrecapaInfo> results = parser.parse(response.getBody());
		
		if(results == null) {
			return null;
		}
			
		if(results.isEmpty()) {
			return null;
		}
		
		return results.get(0);
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAGARME_CREDIT_CARD_CREATION_ERROR;
	}
}
