package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.moip.Moip;

final class VisiPaymoipCard extends ActionVisitorTemplateSimple<PaymoipInfo> {
	
	public VisiPaymoipCard(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<PaymoipInfo> executeTransformationHook(List<PaymoipInfo> recordInfos) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		for(PaymoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToPayWithCreditcard(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToPayWithCreditcard(PaymoipInfo recordInfo) {
		try {
			return Moip.API.multiorders().pay(recordInfo.multipayment, recordInfo.idOrderPartner, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAY_MOIP_CREATION_ERROR;
	}
}
