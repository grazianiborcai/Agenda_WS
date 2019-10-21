package br.com.mind5.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpwotmSetterDel implements InfoSetter<EmpwotmInfo> {
	
	public EmpwotmInfo setAttr(EmpwotmInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodDel(recordInfo);
	}
	
	
	
	private void checkArgument(EmpwotmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpwotmInfo setCodDel(EmpwotmInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
