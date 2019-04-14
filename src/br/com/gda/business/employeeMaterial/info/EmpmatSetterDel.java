package br.com.gda.business.employeeMaterial.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoSetter;

public final class EmpmatSetterDel implements InfoSetter<EmpmatInfo> {
	
	public EmpmatInfo setAttr(EmpmatInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodDel(recordInfo);
	}
	
	
	
	private void checkArgument(EmpmatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpmatInfo setCodDel(EmpmatInfo recordInfo) {
		recordInfo.recordMode = RecordMode.RECORD_DELETED;;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
