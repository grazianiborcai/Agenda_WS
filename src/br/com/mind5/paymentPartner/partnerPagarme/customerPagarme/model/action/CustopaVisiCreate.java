package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.ArrayList;
import java.util.List;

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
		body.append("}");
		
		return body.toString();
	}
	
	
	
	private String makeBodyCustomer(CustopaInfo recordInfo) {
		StringBuilder body = new StringBuilder();
		
		body.append("\"name\":")    	 .append("\"").append(recordInfo.name)    	  .append("\"").append(",");
		body.append("\"email\":")   	 .append("\"").append(recordInfo.email)   	  .append("\"").append(",");		
		body.append("\"document\":")	 .append("\"").append(recordInfo.document)	  .append("\"").append(",");
		body.append("\"document_type\":").append("\"").append(recordInfo.documentType).append("\"").append(",");		
		body.append("\"type\":")    	 .append("\"").append(recordInfo.type)    	  .append("\"").append(",");
		body.append("\"gender\":")    	 .append("\"").append(recordInfo.gender)      .append("\"").append(",");
		body.append("\"birthdate\":")    .append("\"").append(recordInfo.birthdate)   .append("\"").append(",");		
		body.append("\"code\":")    	 .append("\"").append(recordInfo.code)    	  .append("\"");
		
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
