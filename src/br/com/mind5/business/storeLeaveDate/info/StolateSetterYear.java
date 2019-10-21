package br.com.mind5.business.storeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StolateSetterYear implements InfoSetter<StolateInfo> {
	
	public StolateInfo setAttr(StolateInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.yearValidFrom = recordInfo.dateValidFrom.getYear();
		return recordInfo;
	}
	
	
	
	private void checkArgument(StolateInfo recordInfo) {
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
