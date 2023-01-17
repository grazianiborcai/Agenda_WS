package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.json.standard.JstdBodyParser;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class RecipaVisiCreate extends ActionVisitorTemplateSimple<RecipaInfo> {
	
	public RecipaVisiCreate(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<RecipaInfo> executeTransformationHook(List<RecipaInfo> baseInfos) {	
		List<RecipaInfo> results = new ArrayList<>();
		
		
		for(RecipaInfo eachRecod : baseInfos) {
			HttpResponse<String> response = createRecipient(eachRecod);
			
			if (hasError(response) == true)
				return null;
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private HttpResponse<String> createRecipient(RecipaInfo recordInfo) {
		String body = makeBody(recordInfo);
		
		HttpResponse<String> response = tryToCreateRecipient(body);
		
		if (hasError(response) == true)
			writeLogOnError(response);
		
		return response;
	}
	
	
	
	private String makeBody(RecipaInfo recordInfo) {
		StringBuilder body = new StringBuilder();
		
		body.append("{");
		
		body.append("\"name\":").append(recordInfo.name).append(",");
		body.append("\"email\":").append(recordInfo.email).append(",");
		body.append("\"document\":").append(recordInfo.document).append(",");
		body.append("\"type\":").append(recordInfo.type).append(",");
		body.append("\"code\":").append(recordInfo.code);
		
		body.append("}");
		return body.toString();
	}
	
	
	
	private HttpResponse<String> tryToCreateRecipient(String body) {
		try {
			return Unirest.post("https://api.pagar.me/core/v5/recipients")
					  	  .header("accept", "application/json")
						  .header("content-type", "application/json")
						  .header("authorization", "Basic bXl1c2VybmFtZTpteXBhc3N3b3Jk")
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
	
	
	
	private RecipaInfo setAttribute(RecipaInfo recordInfo, HttpResponse<String> response) {
		RecipaInfo parsedResponse = parseResponse(response);	
		
		recordInfo.id = parsedResponse.id;
		
		return recordInfo;
	}
	
	
	
	private RecipaInfo parseResponse(HttpResponse<String> response) {
		JstdBodyParser<RecipaInfo> parser = new JstdBodyParser<>(RecipaInfo.class);
		
		List<RecipaInfo> results = parser.parse(response.getBody());
		
		if(results == null) {
			return null;
		}
			
		if(results.isEmpty()) {
			return null;
		}
		
		return results.get(0);
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAGARME_RECIPIENT_CREATION_ERROR;
	}
}
