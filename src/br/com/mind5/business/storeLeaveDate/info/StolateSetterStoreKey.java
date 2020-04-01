package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StolateSetterStoreKey implements InfoSetter<StolateInfo> {
	
	public StolateInfo setAttr(StolateInfo recordInfo) {
		checkArgument(recordInfo);
		return setStoreKey(recordInfo);
	}
	
	
	
	private void checkArgument(StolateInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StolateInfo setStoreKey(StolateInfo recordInfo) {
		StolateInfo result = new StolateInfo();
		
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
