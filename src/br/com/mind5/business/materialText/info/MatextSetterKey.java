package br.com.mind5.business.materialText.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatextSetterKey implements InfoSetter<MatextInfo> {
	
	public MatextInfo setAttr(MatextInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatextInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatextInfo setKey(MatextInfo recordInfo) {
		MatextInfo enforcedRecord = new MatextInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codMat = recordInfo.codMat;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		
		return enforcedRecord;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
