package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.moip.Moip;

final class VisiRefumoipRefund implements ActionVisitor<RefumoipInfo> {
	
	@Override public List<RefumoipInfo> executeTransformation(List<RefumoipInfo> recordInfos) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		for(RefumoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = refundOrder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> refundOrder(RefumoipInfo recordInfo) {
		return Moip.API.refunds().refundOrder(recordInfo.idOrderPartner, recordInfo.setup);	
	}
}
