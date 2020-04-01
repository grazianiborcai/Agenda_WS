package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CartemSetterUserKey implements InfoSetter<CartemInfo> {
	
	public CartemInfo setAttr(CartemInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(CartemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CartemInfo setKey(CartemInfo recordInfo) {
		CartemInfo enforcedInfo = new CartemInfo();
		
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codUser = recordInfo.codUser;
		enforcedInfo.codLanguage = recordInfo.codLanguage;	
		enforcedInfo.username = recordInfo.username;	
		
		return enforcedInfo;
	}	
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
