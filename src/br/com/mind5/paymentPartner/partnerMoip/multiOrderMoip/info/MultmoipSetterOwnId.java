package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MultmoipSetterOwnId implements InfoSetter<MultmoipInfo> {
	
	public MultmoipInfo setAttr(MultmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.ownId = recordInfo.codOwner + "-" + recordInfo.codPayOrder;
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(MultmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
