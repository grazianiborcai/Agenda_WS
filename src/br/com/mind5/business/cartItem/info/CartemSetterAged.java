package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CartemSetterAged implements InfoSetter<CartemInfo> {
	
	public CartemInfo setAttr(CartemInfo recordInfo) {
		checkArgument(recordInfo);
		recordInfo.isAged = true;
		return recordInfo;
	}
	
	
	
	private void checkArgument(CartemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
