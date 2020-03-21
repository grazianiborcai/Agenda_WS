package br.com.mind5.business.personList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PersolisSetterRestricted implements InfoSetter<PersolisInfo> {
	
	public PersolisInfo setAttr(PersolisInfo recordInfo) {
		checkArgument(recordInfo);
		
		PersolisInfo result = new PersolisInfo();
		
		result.codOwner = recordInfo.codOwner;	
		result.codPerson = recordInfo.codPerson;
		result.codSnapshot = recordInfo.codSnapshot;
		result.name = recordInfo.name;
		result.recordMode = recordInfo.recordMode;
		result.username = recordInfo.username;		
		
		return result;
	}
	
	
	
	private void checkArgument(PersolisInfo recordInfo) {
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
