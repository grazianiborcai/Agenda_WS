package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.json.standard.JstdBodyParser;
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
			
			eachRecod = setAttribute(eachRecod, response);
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
		StringBuilder body = new StringBuilder();
		
		body.append("{");		
		body.append(makeBodyCustomer(recordInfo)).append(",");
		body.append(makeBodyMetadata(recordInfo));
		body.append("}");
		
		return body.toString();
	}
	
	
	
	private String makeBodyCustomer(CustopaInfo recordInfo) {
		Map<String, String> bodyAttr = makeBodyAttr(recordInfo);
		return bodyAttToString(bodyAttr);
	}
	
	
	
	private Map<String, String> makeBodyAttr(CustopaInfo recordInfo) {
		Map<String, String> bodyAttr = new HashMap<>();
		
		bodyAttr = bodyAppendAttr(bodyAttr, "name"         , recordInfo.name);
		bodyAttr = bodyAppendAttr(bodyAttr, "email"        , recordInfo.email);
		bodyAttr = bodyAppendAttr(bodyAttr, "document"     , recordInfo.document);
		bodyAttr = bodyAppendAttr(bodyAttr, "document_type", recordInfo.documentType);
		bodyAttr = bodyAppendAttr(bodyAttr, "type"         , recordInfo.type);
		bodyAttr = bodyAppendAttr(bodyAttr, "gender"       , recordInfo.gender);
		bodyAttr = bodyAppendAttr(bodyAttr, "birthdate"    , recordInfo.birthdate);
		bodyAttr = bodyAppendAttr(bodyAttr, "code"         , recordInfo.code);
		
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
	
	
	
	private String makeBodyMetadata(CustopaInfo recordInfo) {
		String key = "codPayCustomer";
		String value = recordInfo.compoundId;
		StringBuilder body = new StringBuilder();
		
		body.append("\"metadata\":");
		body.append("{");
		
		body.append("\"").append(key).append("\":");
		body.append("\"").append(value).append("\"");
		
		body.append("}");		
		return body.toString();
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
	
	
	
	private CustopaInfo setAttribute(CustopaInfo recordInfo, HttpResponse<String> response) {
		CustopaInfo parsedResponse = parseResponse(response);	
		
		recordInfo.id = parsedResponse.id;
		
		return recordInfo;
	}
	
	
	
	private CustopaInfo parseResponse(HttpResponse<String> response) {
		JstdBodyParser<CustopaInfo> parser = new JstdBodyParser<>(CustopaInfo.class);
		
		List<CustopaInfo> results = parser.parse(response.getBody());
		
		if(results == null) {
			return null;
		}
			
		if(results.isEmpty()) {
			return null;
		}
		
		return results.get(0);
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAGARME_CUSTOMER_CREATION_ERROR;
	}
}
