package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemLog;
import br.com.mind5.model.action.ActionVisitorV1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.moip.Moip;

final class VisiOrdmoipRead implements ActionVisitorV1<OrdmoipInfo> {
	
	@Override public List<OrdmoipInfo> executeTransformation(List<OrdmoipInfo> recordInfos) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(OrdmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToReadOrder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToReadOrder(OrdmoipInfo recordInfo) {
		try {
			return Moip.API.orders().get(recordInfo.idOrderPartner, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
