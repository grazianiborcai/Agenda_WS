package br.com.gda.payment.partnerMoip.orderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.moip.Moip;

final class VisiOrdmoipRead implements ActionVisitor<OrdmoipInfo> {
	
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
