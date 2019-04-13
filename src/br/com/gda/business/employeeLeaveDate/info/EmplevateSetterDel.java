package br.com.gda.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoSetter;

public final class EmplevateSetterDel implements InfoSetter<EmplevateInfo> {
	
	public EmplevateInfo setAttr(EmplevateInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodDel(recordInfo);
	}
	
	
	
	private void checkArgument(EmplevateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmplevateInfo setCodDel(EmplevateInfo recordInfo) {
		recordInfo.recordMode = RecordMode.RECORD_DELETED;;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
