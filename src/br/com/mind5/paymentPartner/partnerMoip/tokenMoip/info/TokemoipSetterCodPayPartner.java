package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class TokemoipSetterCodPayPartner implements InfoSetter<TokemoipInfo> {
	
	public TokemoipInfo setAttr(TokemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(TokemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private TokemoipInfo setKey(TokemoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
