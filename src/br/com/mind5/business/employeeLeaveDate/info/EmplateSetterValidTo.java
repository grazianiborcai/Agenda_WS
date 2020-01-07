package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmplateSetterValidTo implements InfoSetter<EmplateInfo> {
	
	public EmplateInfo setAttr(EmplateInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.validTo = LocalDateTime.of(recordInfo.dateValidTo, recordInfo.timeValidTo);
		return recordInfo;
	}
	
	
	
	private void checkArgument(EmplateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
