package br.com.mind5.message.sysMessage.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SymsgSetterRestoreBase implements InfoSetter<SymsgInfo> {
	
	public SymsgInfo setAttr(SymsgInfo recordInfo) {
		checkArgument(recordInfo);
		return setRestoreBase(recordInfo);
	}
	
	
	
	private void checkArgument(SymsgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SymsgInfo setRestoreBase(SymsgInfo recordInfo) {
		recordInfo.codLanguage = recordInfo.codLanguageBase;		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
