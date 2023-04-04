package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class SplitapaVisiRead extends ActionVisitorTemplateSimple<SplitapaInfo> {
	
	public SplitapaVisiRead(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<SplitapaInfo> executeTransformationHook(List<SplitapaInfo> baseInfos) {	
		List<SplitapaInfo> results = new ArrayList<>();		
		
		for(SplitapaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = readOrder(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod.responseBody = response.getBody();
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> readOrder(SplitapaInfo recordInfo) {
		String authorization = makeAuthorization(recordInfo);
		String url = makeUrl(recordInfo);
		
		HttpResponse<String> response = tryToReadOrder(authorization, url);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeAuthorization(SplitapaInfo recordInfo) {
		return recordInfo.authorization;
	}
	
	
	
	private String makeUrl(SplitapaInfo recordInfo) {
		return "https://api.pagar.me/core/v5/orders/" + recordInfo.payordData.idPaymentPartner;
	}
	
	
	
	private HttpResponse<String> tryToReadOrder(String authorization, String url) {
		try {
			return Unirest.get(url)
					  	  .header("accept", "application/json")
						  .header("content-type", "application/json")
						  .header("authorization", authorization)
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
		return SystemCode.PAGARME_ORDER_SPLIT_READ_ERROR;
	}
}
