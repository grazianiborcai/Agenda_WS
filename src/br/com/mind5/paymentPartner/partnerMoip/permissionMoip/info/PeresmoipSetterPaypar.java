package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PeresmoipSetterPaypar implements InfoSetter<PeresmoipInfo> {
	
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
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}