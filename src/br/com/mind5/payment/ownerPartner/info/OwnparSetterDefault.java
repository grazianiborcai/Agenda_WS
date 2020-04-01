package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
