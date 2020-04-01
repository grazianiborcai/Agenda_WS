package br.com.mind5.payment.countryPartner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CounparSetterDefault implements InfoSetter<CounparInfo> {
	
	public CounparInfo setAttr(CounparInfo recordInfo) {
		checkArgument(recordInfo);
		return setDefault(recordInfo);
	}
	
	
	
	private void checkArgument(CounparInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CounparInfo setDefault(CounparInfo recordInfo) {
		CounparInfo result = makeClone(recordInfo);
		result.isDefault = true;
		return result;
	}	
	
	
	
	private CounparInfo makeClone(CounparInfo recordInfo) {
		try {
			return (CounparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
