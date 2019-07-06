package br.com.gda.payment.accessMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;
import br.com.moip.Moip;

final class VisiAccemoipUrl implements ActionVisitor<AccemoipInfo> {
	
	@Override public List<AccemoipInfo> executeTransformation(List<AccemoipInfo> recordInfos) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		for(AccemoipInfo eachRecod : recordInfos) {
			String response;
			response = tryToBuildUrl(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private String tryToBuildUrl(AccemoipInfo recordInfo) {
		try {
			return Moip.API.connect().buildUrl(recordInfo.sysparData.idPayPartnerApp, 
											   recordInfo.sysparData.urlReturn, 
											   recordInfo.scopes, 
											   recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private AccemoipInfo setAttribute(AccemoipInfo recordInfo, String response) {
		recordInfo.url = response;
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
