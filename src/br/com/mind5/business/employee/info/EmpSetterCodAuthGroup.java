package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterCodAuthGroup implements InfoSetter<EmpInfo> {
	
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
		recordInfo.codAuthGroup = AuthGroup.EMPLOYEE.getCodAuthGroup();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
