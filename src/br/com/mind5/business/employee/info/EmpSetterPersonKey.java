package br.com.mind5.business.employee.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterPersonKey implements InfoSetter<EmpInfo> {
	
	public EmpInfo setAttr(EmpInfo recordInfo) {
		checkArgument(recordInfo);
		return setPersonKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmpInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.personData == null) {
			logException(new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpInfo setPersonKey(EmpInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = recordInfo.codPerson;
		recordInfo.personData.username = recordInfo.username;
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
