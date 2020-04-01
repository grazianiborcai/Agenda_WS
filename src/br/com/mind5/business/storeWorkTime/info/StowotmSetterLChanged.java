package br.com.mind5.business.storeWorkTime.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StowotmSetterLChanged implements InfoSetter<StowotmInfo> {
	
	public StowotmInfo setAttr(StowotmInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genLastChanged();
		return recordInfo;
	}
	
	
	
	private void checkArgument(StowotmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.localDateTimeNow();
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
