package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpnapSetterKey implements InfoSetter<EmpnapInfo> {
	
	public EmpnapInfo setAttr(EmpnapInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodAuthGrRole(recordInfo);
	}
	
	
	
	private void checkArgument(EmpnapInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpnapInfo setCodAuthGrRole(EmpnapInfo recordInfo) {
		EmpnapInfo result = new EmpnapInfo();
		result.codOwner = recordInfo.codOwner;
		result.codEmployee = recordInfo.codEmployee;
		result.codSnapshot = recordInfo.codSnapshot;
		
		return result;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
