package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class RefumoipSetterPaypar implements InfoSetter<RefumoipInfo> {
	
	public RefumoipInfo setAttr(RefumoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(RefumoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
