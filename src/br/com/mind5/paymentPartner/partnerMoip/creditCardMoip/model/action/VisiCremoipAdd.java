package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemLog;
import br.com.mind5.model.action.ActionVisitorV1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.moip.Moip;

final class VisiCremoipAdd implements ActionVisitorV1<CremoipInfo> {
	
	@Override public List<CremoipInfo> executeTransformation(List<CremoipInfo> recordInfos) {
		List<CremoipInfo> results = new ArrayList<>();
		
		for(CremoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToAddMoip(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToAddMoip(CremoipInfo recordInfo) {
		try {
			return Moip.API.customers().addCreditCard(recordInfo.funding, recordInfo.cusparData.customerId, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private CremoipInfo setAttribute(CremoipInfo recordInfo, Map<String, Object> response) {		
		@SuppressWarnings("unchecked")
		Map<String, Object> creditCard = (Map<String, Object>) response.get("creditCard");	
		
		recordInfo.creditCardId = (String) creditCard.get("id");
		recordInfo.creditCardBrand = (String) creditCard.get("brand");
		recordInfo.creditCardLast4 = (String) creditCard.get("last4");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
