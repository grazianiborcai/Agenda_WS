package br.com.mind5.business.material.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatSetterMatextKey implements InfoSetter<MatInfo> {
	
	public MatInfo setAttr(MatInfo recordInfo) {
		checkArgument(recordInfo);
		return setMatextKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatInfo setMatextKey(MatInfo recordInfo) {
		for (MatextInfo eachMatext : recordInfo.matextes) {
			eachMatext.codOwner = recordInfo.codOwner;
			eachMatext.codMat = recordInfo.codMat;
			eachMatext.username = recordInfo.username;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
