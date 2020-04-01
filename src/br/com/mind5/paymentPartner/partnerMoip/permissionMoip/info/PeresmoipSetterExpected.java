package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PeresmoipSetterExpected implements InfoSetter<PeresmoipInfo> {
	
	public PeresmoipInfo setAttr(PeresmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setExpected(recordInfo);
	}
	
	
	
	private void checkArgument(PeresmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PeresmoipInfo setExpected(PeresmoipInfo recordInfo) {
		recordInfo.isExpected = true;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
