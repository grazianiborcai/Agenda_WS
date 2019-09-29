package br.com.gda.business.company.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class CompSetterCreatedBy implements InfoSetter<CompInfo> {
	
	public CompInfo setAttr(CompInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
	
	
	
	private void checkArgument(CompInfo recordInfo) {
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
