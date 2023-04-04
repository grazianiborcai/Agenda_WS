package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.JsonBuilder;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class SplitapaVisiCreate extends ActionVisitorTemplateSimple<SplitapaInfo> {
	
	public SplitapaVisiCreate(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<SplitapaInfo> executeTransformationHook(List<SplitapaInfo> baseInfos) {	
		List<SplitapaInfo> results = new ArrayList<>();
		
		
		for(SplitapaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = createOrder(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod.responseBody = response.getBody();
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createOrder(SplitapaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		
		HttpResponse<String> response = tryToCreateOrder(body, authorization);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();		

		builder.addBuilderToJson(makeBodyCode(recordInfo));
		builder.addBuilderToJson(makeBodyItems(recordInfo));
		builder.addBuilderToJson(makeBodyCustomer(recordInfo));
		builder.addBuilderToJson(makeBodyPayments(recordInfo));
		
		return builder.build();
	}
	
	
	
	private JsonBuilder makeBodyCode(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("code", recordInfo.code);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyItems(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addArrayToJson("items", recordInfo.items);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyCustomer(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("customer_id", recordInfo.customerId);		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodyPayments(SplitapaInfo recordInfo) {
		JsonBuilder builderTemp = new JsonBuilder();
		JsonBuilder builder    = new JsonBuilder();
		
		builderTemp.addObjToJson("payment_method", recordInfo.paymentMethod);
		builderTemp.addNestedObjToJson("credit_card", recordInfo.creditCard);
		builderTemp.addArrayToJson("split", makeBodySplit(recordInfo).buildWithoutBraces());

		builder.addArrayToJson("payments", builderTemp.build());		
		return builder;
	}
	
	
	
	private JsonBuilder makeBodySplit(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();		
		
		for (Map.Entry<Map<String,String>,Map<String,String>> eachSplit : recordInfo.split.entrySet()) {
			JsonBuilder builderTemp = new JsonBuilder();

			builderTemp.addObjToJson(eachSplit.getKey());
			builderTemp.addNestedObjToJson("options", eachSplit.getValue());
			builder.addStrToJson(builderTemp.build());
		}		
		
		return builder;
	}
	
	
	
	private String makeAuthorization(SplitapaInfo recordInfo) {
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
		return SystemCode.PAGARME_ORDER_SPLIT_CREATION_ERROR;
	}
}
