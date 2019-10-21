package br.com.mind5.payment.customerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusparSetterCompoundId implements InfoSetter<CusparInfo> {
	
	public CusparInfo setAttr(CusparInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(CusparInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusparInfo setKey(CusparInfo recordInfo) {
		recordInfo.compoundId = String.valueOf(recordInfo.codOwner) 
				              + "-" 
				              + String.valueOf(recordInfo.codPayCustomer);
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
