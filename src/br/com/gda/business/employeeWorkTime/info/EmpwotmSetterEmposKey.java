package br.com.gda.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class EmpwotmSetterEmposKey implements InfoSetter<EmpwotmInfo> {
	
	public EmpwotmInfo setAttr(EmpwotmInfo recordInfo) {
		checkArgument(recordInfo);
		return setCategKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmpwotmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpwotmInfo setCategKey(EmpwotmInfo recordInfo) {
		EmpwotmInfo enforcedRecord = new EmpwotmInfo();
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
