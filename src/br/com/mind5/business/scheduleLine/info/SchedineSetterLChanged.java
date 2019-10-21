package br.com.mind5.business.scheduleLine.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedineSetterLChanged implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genLastChanged();
		return recordInfo;
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.localDateTimeNow();
	}
}
