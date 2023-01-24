package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			HttpResponse<String> response = createCustomer(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createCustomer(CrecapaInfo recordInfo) {
		String body = makeBody(recordInfo);
		String authorization = makeAuthorization(recordInfo);
		String url = makeUrl(recordInfo);
		
		HttpResponse<String> response = tryToCreateCreditCard(body, authorization, url);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(CrecapaInfo recordInfo) {
		StringBuilder body = new StringBuilder();
		
		body.append("{");		
		body.append(makeBodyCreditCard(recordInfo)).append(",");
		body.append(makeBodyMetadata(recordInfo));
		body.append("}");
		
		return body.toString();
	}
	
	
	
	private String makeBodyCreditCard(CrecapaInfo recordInfo) {
		Map<String, String> bodyAttr = makeBodyAttr(recordInfo);
		return bodyAttToString(bodyAttr);
	}
	
	
	
	private Map<String, String> makeBodyAttr(CrecapaInfo recordInfo) {
		Map<String, String> bodyAttr = new HashMap<>();
		
		bodyAttr = bodyAppendAttr(bodyAttr, "customer_id"    , recordInfo.customerId);
		bodyAttr = bodyAppendAttr(bodyAttr, "number"         , recordInfo.cardNumber);
		bodyAttr = bodyAppendAttr(bodyAttr, "holder_name"    , recordInfo.nameHolder);
		bodyAttr = bodyAppendAttr(bodyAttr, "holder_document", recordInfo.cpfHolder);
		bodyAttr = bodyAppendAttr(bodyAttr, "exp_month"      , recordInfo.expirationMonth);
		bodyAttr = bodyAppendAttr(bodyAttr, "exp_year"       , recordInfo.expirationYear);
		bodyAttr = bodyAppendAttr(bodyAttr, "cvv"    		 , recordInfo.cardCvc);
		bodyAttr = bodyAppendAttr(bodyAttr, "brand"          , recordInfo.creditCardBrand);		
		bodyAttr = bodyAppendAttr(bodyAttr, "label"          , recordInfo.label);
		bodyAttr = bodyAppendAttr(bodyAttr, "options"        , recordInfo.options);
		
		return bodyAttr;
	}
	
	
	
	private Map<String, String> bodyAppendAttr(Map<String, String> bodyAttr, String key, String value) {
		if (value == null)
			return bodyAttr;
		
		if (bodyAttr != null)
			bodyAttr.put(key, value);
		
		return bodyAttr;
	}
	
	
	
	private String bodyAttToString(Map<String, String> bodyAttr) {
		StringBuilder body = new StringBuilder();
		int semaphore = 0;
		
		for (Map.Entry<String, String> entry : bodyAttr.entrySet()) {
			if (semaphore != 0)
				body.append(",");
			
			body.append("\"").append(entry.getKey()).append("\":").append("\"").append(entry.getValue()).append("\"");			
			semaphore = 1;
		}
		
		return body.toString();
	}
	
	
	private String makeBodyMetadata(CrecapaInfo recordInfo) {
		String key = "codCreditCard";
		String value = recordInfo.metadata;
		StringBuilder body = new StringBuilder();
		
		body.append("\"metadata\":");
		body.append("{");
		
		body.append("\"").append(key).append("\":");
		body.append("\"").append(value).append("\"");
		
		body.append("}");		
		return body.toString();
	}
	
	
	
	private String makeAuthorization(CrecapaInfo recordInfo) {
		return recordInfo.authorization;
	}
	
	
	
	private String makeUrl(CrecapaInfo recordInfo) {
		return "https://api.pagar.me/core/v5/customers/" + recordInfo.customerId + "/cards";
	}
	
	
	
	private HttpResponse<String> tryToCreateCreditCard(String body, String authorization, String url) {
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
