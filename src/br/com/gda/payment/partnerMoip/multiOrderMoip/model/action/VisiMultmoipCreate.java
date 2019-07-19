package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.moip.Moip;

final class VisiMultmoipCreate implements ActionVisitor<MultmoipInfo> {
	
	@Override public List<MultmoipInfo> executeTransformation(List<MultmoipInfo> recordInfos) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		for(MultmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToCreateMultiorder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
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
	
	
	
	@SuppressWarnings("unchecked")
	private MultmoipInfo setAttribute(MultmoipInfo recordInfo, Map<String, Object> response) {				
		Map<String, Object> amounts = (Map<String, Object>) response.get("amount");	
		Map<String, Object> links = (Map<String, Object>) response.get("_links");		
		Map<String, Object> selfs = (Map<String, Object>) links.get("self");			
		Map<String, Object> checkout = (Map<String, Object>) links.get("checkout");			
		Map<String, Object> payCreditCard = (Map<String, Object>) checkout.get("payCreditCard");
		Map<String, Object> payBoleto = (Map<String, Object>) checkout.get("payBoleto");	
		List<Map<String, Object>> orders = (List<Map<String, Object>>) response.get("orders");	
		
		recordInfo.idOrderPartner = (String) response.get("id");
		recordInfo.statusOrderPartner = (String) response.get("status");
		recordInfo.amountTotalPartner = String.valueOf(amounts.get("total"));
		recordInfo.amountCurrencyPartner = (String) amounts.get("currency");		
		recordInfo.urlSelf = (String) selfs.get("href");		
		recordInfo.urlPayCard = (String) payCreditCard.get("redirectHref");
		recordInfo.urlPayBoleto = (String) payBoleto.get("redirectHref");
		
		return recordInfo;
	} 
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
