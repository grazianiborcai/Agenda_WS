package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.moip.Moip;

final class VisiMultmoipRead implements ActionVisitor<MultmoipInfo> {
	
	@Override public List<MultmoipInfo> executeTransformation(List<MultmoipInfo> recordInfos) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		for(MultmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToReadOrder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToReadOrder(MultmoipInfo recordInfo) {
		try {
			return Moip.API.multiorders().get(recordInfo.idOrderPartner, recordInfo.setup);			
			
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
