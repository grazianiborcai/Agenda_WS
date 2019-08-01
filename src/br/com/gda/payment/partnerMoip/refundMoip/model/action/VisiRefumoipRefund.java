package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.moip.Moip;

final class VisiRefumoipRefund implements ActionVisitor<RefumoipInfo> {
	
	@Override public List<RefumoipInfo> executeTransformation(List<RefumoipInfo> recordInfos) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		for(RefumoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToRefundOrder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToRefundOrder(RefumoipInfo recordInfo) {
		try {
			return Moip.API.refunds().refundOrder(recordInfo.idOrderPartner, recordInfo.setup);			
			
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
