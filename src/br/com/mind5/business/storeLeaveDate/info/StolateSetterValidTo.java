package br.com.mind5.business.storeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StolateSetterValidTo implements InfoSetter<StolateInfo> {
	
	public StolateInfo setAttr(StolateInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.validTo = LocalDateTime.of(recordInfo.dateValidTo, recordInfo.timeValidTo);
		return recordInfo;
	}
	
	
	
	private void checkArgument(StolateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
