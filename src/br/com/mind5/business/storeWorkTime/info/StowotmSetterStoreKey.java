package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StowotmSetterStoreKey implements InfoSetter<StowotmInfo> {
	
	public StowotmInfo setAttr(StowotmInfo recordInfo) {
		checkArgument(recordInfo);
		return setStoreKey(recordInfo);
	}
	
	
	
	private void checkArgument(StowotmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StowotmInfo setStoreKey(StowotmInfo recordInfo) {
		StowotmInfo result = new StowotmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
