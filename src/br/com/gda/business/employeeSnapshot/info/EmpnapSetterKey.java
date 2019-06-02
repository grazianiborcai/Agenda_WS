package br.com.gda.business.employeeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
