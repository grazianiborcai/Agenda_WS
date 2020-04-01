package br.com.mind5.business.materialStore.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatoreSetterStoreKey implements InfoSetter<MatoreInfo> {
	
	public MatoreInfo setAttr(MatoreInfo recordInfo) {
		checkArgument(recordInfo);
		
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
	
	
	
	private void checkArgument(MatoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
