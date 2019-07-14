package br.com.gda.payment.partnerMoip.customerMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.moip.Moip;

final class VisiCusmoipCreate implements ActionVisitor<CusmoipInfo> {
	
	@Override public List<CusmoipInfo> executeTransformation(List<CusmoipInfo> recordInfos) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		for(CusmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToCreateMoip(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToCreateMoip(CusmoipInfo recordInfo) {
		try {
			return Moip.API.customers().create(recordInfo.requestBody, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private CusmoipInfo setAttribute(CusmoipInfo recordInfo, Map<String, Object> response) {
		recordInfo.customerId = (String) response.get("id");
		
		@SuppressWarnings("unchecked")
		Map<String, Object> links = (Map<String, Object>) response.get("_links");		
		recordInfo.customerLink = links.get("self").toString();
		recordInfo.accountLink = links.get("hostedAccount").toString();
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
