package br.com.mind5.business.materialStock.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatockSetterKey_ implements InfoSetter<MatockInfo> {
	
	public MatockInfo setAttr(MatockInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatockInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatockInfo setKey(MatockInfo recordInfo) {
		MatockInfo result = new MatockInfo();
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codMat = recordInfo.codMat;
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
