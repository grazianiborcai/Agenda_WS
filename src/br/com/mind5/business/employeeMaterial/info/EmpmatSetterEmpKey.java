package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		SystemLog.logError(this.getClass(), e);
	}	
}
