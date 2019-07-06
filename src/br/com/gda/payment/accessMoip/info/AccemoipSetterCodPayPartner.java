package br.com.gda.payment.accessMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.Paypar;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class AccemoipSetterCodPayPartner implements InfoSetter<AccemoipInfo> {
	
	public AccemoipInfo setAttr(AccemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(AccemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private AccemoipInfo setKey(AccemoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
