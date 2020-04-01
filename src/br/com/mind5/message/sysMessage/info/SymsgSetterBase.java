package br.com.mind5.message.sysMessage.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SymsgSetterBase implements InfoSetter<SymsgInfo> {
	
	public SymsgInfo setAttr(SymsgInfo recordInfo) {
		checkArgument(recordInfo);
		return setBase(recordInfo);
	}
	
	
	
	private void checkArgument(SymsgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SymsgInfo setBase(SymsgInfo recordInfo) {
		recordInfo.codLanguageBase = recordInfo.codLanguage;		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
