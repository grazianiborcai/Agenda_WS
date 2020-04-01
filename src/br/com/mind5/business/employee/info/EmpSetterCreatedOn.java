package br.com.mind5.business.employee.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterCreatedOn implements InfoSetter<EmpInfo> {
	
	public EmpInfo setAttr(EmpInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
	
	
	
	private void checkArgument(EmpInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
