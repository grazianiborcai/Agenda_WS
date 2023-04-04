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

public final class SplitapaVisiCancel extends ActionVisitorTemplateSimple<SplitapaInfo> {
	
	public SplitapaVisiCancel(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<SplitapaInfo> executeTransformationHook(List<SplitapaInfo> baseInfos) {	
		List<SplitapaInfo> results = new ArrayList<>();		
		
		for(SplitapaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = cancelOrder(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod.responseBody = response.getBody();
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> cancelOrder(SplitapaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		String url = makeUrl(recordInfo);
		
		HttpResponse<String> response = tryToCancelOrder(body, authorization, url);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(SplitapaInfo recordInfo) {
		JsonBuilder builder = new JsonBuilder();
		
		builder.addObjToJson("amount", recordInfo.amount);	
		builder.addArrayToJson("split", makeBodySplit(recordInfo).buildWithoutBraces());
		
		return builder.build();
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
	
	
	
	private String makeUrl(SplitapaInfo recordInfo) {
		return "https://api.pagar.me/core/v5/charges/" + recordInfo.payordData.idPaymentPartner;
	}
	
	
	
	private HttpResponse<String> tryToCancelOrder(String body, String authorization, String url) {
		try {
			return Unirest.delete(url)
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
		return SystemCode.PAGARME_ORDER_SPLIT_CANCEL_ERROR;
	}
}
