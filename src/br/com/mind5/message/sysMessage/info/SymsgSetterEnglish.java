package br.com.mind5.message.sysMessage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.Langu;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SymsgSetterEnglish implements InfoSetter<SymsgInfo> {
	
	public SymsgInfo setAttr(SymsgInfo recordInfo) {
		checkArgument(recordInfo);
		return setEnglish(recordInfo);
	}
	
	
	
	private void checkArgument(SymsgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SymsgInfo setEnglish(SymsgInfo recordInfo) {
		recordInfo.codLanguage = Langu.ENGLISH.getCod();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
