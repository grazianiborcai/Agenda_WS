package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.JsonBuilder;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class OrdapaVisiCreate extends ActionVisitorTemplateSimple<OrdapaInfo> {
	
	public OrdapaVisiCreate(DeciTreeOption<OrdapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<OrdapaInfo> executeTransformationHook(List<OrdapaInfo> baseInfos) {	
		List<OrdapaInfo> results = new ArrayList<>();
		
		
		for(OrdapaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = createOrder(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod.responseBody = response.getBody();
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createOrder(OrdapaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		
		HttpResponse<String> response = tryToCreateOrder(body, authorization);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(OrdapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();		

		builder.addBuilderToJson(makeBodyCode(recordInfo));
		builder.addBuilderToJson(makeBodyItems(recordInfo));
		builder.addBuilderToJson(makeBodyCustomer(recordInfo));
		builder.addBuilderToJson(makeBodyPayments(recordInfo));
		
		return builder.build();
	}
	
	
	
	private JsonBuilder makeBodyCode(OrdapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("code", recordInfo.code);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyItems(OrdapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addArrayToJson("items", recordInfo.items);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyCustomer(OrdapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("customer_id", recordInfo.customerId);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyPayments(OrdapaInfo recordInfo) {
		JsonBuilder builderTemp = new JsonBuilder();
		JsonBuilder builder     = new JsonBuilder();
		
		builderTemp.addObjToJson("payment_method", recordInfo.paymentMethod);
		builderTemp.addBuilderToJson("credit_card", makeBodyCreditcard(recordInfo));

		builder.addArrayToJson("payments", builderTemp.build());		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyCreditcard(OrdapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();		

		builder.addNestedObjToJson("card", recordInfo.card);
		builder.addObjToJson(recordInfo.payments);
		
		return builder;
	}
	
	
	
	private String makeAuthorization(OrdapaInfo recordInfo) {
		return recordInfo.authorization;
	}
	
	
	
	private HttpResponse<String> tryToCreateOrder(String body, String authorization) {
		try {
			return Unirest.post("https://api.pagar.me/core/v5/orders")
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
		return SystemCode.PAGARME_ORDER_CREATION_ERROR;
	}
}
