package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmplateSetterValidFrom implements InfoSetter<EmplateInfo> {
	
	public EmplateInfo setAttr(EmplateInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.validFrom = LocalDateTime.of(recordInfo.dateValidFrom, recordInfo.timeValidFrom);
		return recordInfo;
	}
	
	
	
	private void checkArgument(EmplateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
