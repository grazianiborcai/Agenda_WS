package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemLog;
import br.com.mind5.model.action.ActionVisitorV1;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.moip.Moip;

final class VisiMultmoipCreate implements ActionVisitorV1<MultmoipInfo> {
	
	@Override public List<MultmoipInfo> executeTransformation(List<MultmoipInfo> recordInfos) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		for(MultmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToCreateMultiorder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToCreateMultiorder(MultmoipInfo recordInfo) {
		try {
			return Moip.API.multiorders().create(recordInfo.multiorder, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
