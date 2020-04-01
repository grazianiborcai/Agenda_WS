package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
