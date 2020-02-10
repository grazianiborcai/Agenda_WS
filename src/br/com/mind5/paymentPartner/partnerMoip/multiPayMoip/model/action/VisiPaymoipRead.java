package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.moip.Moip;

final class VisiPaymoipRead implements ActionVisitor<PaymoipInfo> {
	
	@Override public List<PaymoipInfo> executeTransformation(List<PaymoipInfo> recordInfos) {
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
			return Moip.API.multipayments().get(recordInfo.idPaymentPartner, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
