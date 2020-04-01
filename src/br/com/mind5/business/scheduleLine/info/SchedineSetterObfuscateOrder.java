package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedineSetterObfuscateOrder implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		return setOrder(recordInfo);
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedineInfo setOrder(SchedineInfo recordInfo) {
		recordInfo.codOrder = DefaultValue.number();
		recordInfo.codOrderItem = DefaultValue.number();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
