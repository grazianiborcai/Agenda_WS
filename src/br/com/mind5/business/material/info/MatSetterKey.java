package br.com.mind5.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatSetterKey implements InfoSetter<MatInfo> {
	
	public MatInfo setAttr(MatInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatInfo setKey(MatInfo recordInfo) {
		MatInfo enforcedRecord = new MatInfo();
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
