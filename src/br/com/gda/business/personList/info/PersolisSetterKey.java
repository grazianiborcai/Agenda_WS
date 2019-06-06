package br.com.gda.business.personList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PersolisSetterKey implements InfoSetter<PersolisInfo> {
	
	public PersolisInfo setAttr(PersolisInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(PersolisInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PersolisInfo setKey(PersolisInfo recordInfo) {
		PersolisInfo result = new PersolisInfo();
		result.codOwner = recordInfo.codOwner;
		result.codPerson = recordInfo.codPerson;
		return result;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
