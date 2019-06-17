package br.com.gda.payment.ownerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OwnparSetterDefault implements InfoSetter<OwnparInfo> {
	
	public OwnparInfo setAttr(OwnparInfo recordInfo) {
		checkArgument(recordInfo);
		return setDefault(recordInfo);
	}
	
	
	
	private void checkArgument(OwnparInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnparInfo setDefault(OwnparInfo recordInfo) {
		OwnparInfo result = makeClone(recordInfo);
		result.isDefault = true;
		return result;
	}	
	
	
	
	private OwnparInfo makeClone(OwnparInfo recordInfo) {
		try {
			return (OwnparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
