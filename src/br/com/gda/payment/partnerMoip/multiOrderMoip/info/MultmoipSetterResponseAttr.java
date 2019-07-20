package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class MultmoipSetterResponseAttr implements InfoSetter<MultmoipInfo> {
	
	public MultmoipInfo setAttr(MultmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setResponseAtt(recordInfo);
	}
	
	
	
	private void checkArgument(MultmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private MultmoipInfo setResponseAtt(MultmoipInfo recordInfo) {
		Map<String, Object> amounts = (Map<String, Object>) recordInfo.response.get("amount");	
		Map<String, Object> links = (Map<String, Object>) recordInfo.response.get("_links");		
		Map<String, Object> selfs = (Map<String, Object>) links.get("self");			
		Map<String, Object> checkout = (Map<String, Object>) links.get("checkout");			
		Map<String, Object> payCreditCard = (Map<String, Object>) checkout.get("payCreditCard");
		Map<String, Object> payBoleto = (Map<String, Object>) checkout.get("payBoleto");
		
		recordInfo.idOrderPartner = (String) recordInfo.response.get("id");
		recordInfo.statusOrderPartner = (String) recordInfo.response.get("status");
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
