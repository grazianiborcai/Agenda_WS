package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PaymoipSetterPaypar implements InfoSetter<PaymoipInfo> {
	
	public PaymoipInfo setAttr(PaymoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PaymoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
