package br.com.mind5.business.employeePosition.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmposSetterEmpKey implements InfoSetter<EmposInfo> {
	
	public EmposInfo setAttr(EmposInfo recordInfo) {
		checkArgument(recordInfo);
		return setCategKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmposInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmposInfo setCategKey(EmposInfo recordInfo) {
		EmposInfo enforcedRecord = new EmposInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEmployee = recordInfo.codEmployee;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		enforcedRecord.username = recordInfo.username;
		
		return enforcedRecord;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
