package br.com.mind5.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmplevateSetterEmposKey implements InfoSetter<EmplevateInfo> {
	
	public EmplevateInfo setAttr(EmplevateInfo recordInfo) {
		checkArgument(recordInfo);
		return setCategKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmplevateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmplevateInfo setCategKey(EmplevateInfo recordInfo) {
		EmplevateInfo enforcedRecord = new EmplevateInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codStore = recordInfo.codStore;
		enforcedRecord.codEmployee = recordInfo.codEmployee;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		enforcedRecord.username = recordInfo.username;
		
		return enforcedRecord;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
