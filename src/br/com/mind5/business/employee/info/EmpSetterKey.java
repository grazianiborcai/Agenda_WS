package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterKey implements InfoSetter<EmpInfo> {
	
	public EmpInfo setAttr(EmpInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodAuthGrRole(recordInfo);
	}
	
	
	
	private void checkArgument(EmpInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpInfo setCodAuthGrRole(EmpInfo recordInfo) {
		EmpInfo result = new EmpInfo();
		result.codOwner = recordInfo.codOwner;
		result.codEmployee = recordInfo.codEmployee;
		
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
