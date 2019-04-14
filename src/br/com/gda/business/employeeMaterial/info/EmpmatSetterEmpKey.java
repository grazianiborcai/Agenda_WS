package br.com.gda.business.employeeMaterial.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class EmpmatSetterEmpKey implements InfoSetter<EmpmatInfo> {
	
	public EmpmatInfo setAttr(EmpmatInfo recordInfo) {
		checkArgument(recordInfo);
		return setCategKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmpmatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpmatInfo setCategKey(EmpmatInfo recordInfo) {
		EmpmatInfo enforcedRecord = new EmpmatInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
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
