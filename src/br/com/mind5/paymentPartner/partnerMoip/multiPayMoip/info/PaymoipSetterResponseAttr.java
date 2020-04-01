package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PaymoipSetterResponseAttr implements InfoSetter<PaymoipInfo> {
	
	public PaymoipInfo setAttr(PaymoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setResponseAtt(recordInfo);
	}
	
	
	
	private void checkArgument(PaymoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PaymoipInfo setResponseAtt(PaymoipInfo recordInfo) {		
		recordInfo.idPaymentPartner = (String) recordInfo.response.get("id");
		recordInfo.statusPaymentPartner = (String) recordInfo.response.get("status");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
