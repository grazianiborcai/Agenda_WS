package br.com.mind5.business.materialMovement.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatmovSetterKey implements InfoSetter<MatmovInfo> {
	
	public MatmovInfo setAttr(MatmovInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatmovInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatmovInfo setKey(MatmovInfo recordInfo) {
		MatmovInfo result = new MatmovInfo();
		result.codOwner = recordInfo.codOwner;
		result.codMatmov = recordInfo.codMatmov;
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
