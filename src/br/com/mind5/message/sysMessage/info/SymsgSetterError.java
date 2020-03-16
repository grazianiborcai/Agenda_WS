package br.com.mind5.message.sysMessage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SymsgSetterError implements InfoSetter<SymsgInfo> {
	
	public SymsgInfo setAttr(SymsgInfo recordInfo) {
		checkArgument(recordInfo);
		return setErrorKey(recordInfo);
	}
	
	
	
	private void checkArgument(SymsgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SymsgInfo setErrorKey(SymsgInfo recordInfo) {	
		recordInfo.codMsg = SystemCode.SYS_MESSAGE_NOT_FOUND;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
