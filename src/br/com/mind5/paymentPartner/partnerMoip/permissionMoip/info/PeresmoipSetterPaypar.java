package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class PeresmoipSetterPaypar implements InfoSetter<PeresmoipInfo> {
	
	public PeresmoipInfo setAttr(PeresmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PeresmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
