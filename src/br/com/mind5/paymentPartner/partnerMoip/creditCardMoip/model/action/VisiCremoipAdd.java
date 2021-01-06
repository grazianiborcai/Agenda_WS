package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.moip.Moip;

final class VisiCremoipAdd extends ActionVisitorTemplateSimple<CremoipInfo> {
	
	public VisiCremoipAdd(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CremoipInfo> executeTransformationHook(List<CremoipInfo> baseInfos) {	
		List<CremoipInfo> results = new ArrayList<>();
		
		for(CremoipInfo eachRecod : baseInfos) {
			Map<String, Object> response;
			response = tryToAddMoip(eachRecod);
			
			if (response == null)
				return null;
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToAddMoip(CremoipInfo recordInfo) {
		try {
			return Moip.API.customers().addCreditCard(recordInfo.funding, recordInfo.cusparData.customerId, recordInfo.setup);			
			
		} catch (Exception e) {
			super.logException(e);
			//TODO: Escrever em log detalhes do erro
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
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.CREDIT_CARD_MOIP_CREATION_ERROR;
	}
}
