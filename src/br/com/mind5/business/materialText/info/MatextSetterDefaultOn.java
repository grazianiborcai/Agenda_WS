package br.com.mind5.business.materialText.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatextSetterDefaultOn implements InfoSetter<MatextInfo> {
	
	public MatextInfo setAttr(MatextInfo recordInfo) {
		checkArgument(recordInfo);
		return setDefaultOn(recordInfo);
	}
	
	
	
	private void checkArgument(MatextInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatextInfo setDefaultOn(MatextInfo recordInfo) {
		recordInfo.isDefault = true;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
