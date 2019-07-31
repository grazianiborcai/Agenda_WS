package br.com.gda.payment.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class RefumoipSetterResponseAttr implements InfoSetter<RefumoipInfo> {
	
	public RefumoipInfo setAttr(RefumoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setResponseAtt(recordInfo);
	}
	
	
	
	private void checkArgument(RefumoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private RefumoipInfo setResponseAtt(RefumoipInfo recordInfo) {		
		recordInfo.idRefundPartner = (String) recordInfo.response.get("id");
		recordInfo.statusRefundPartner = (String) recordInfo.response.get("status");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
