package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class CartemSetterSymsgL07 implements InfoSetter<CartemInfo> {
	
	public CartemInfo setAttr(CartemInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.symsgData = new SymsgInfo();
		recordInfo.symsgData.codLanguage = recordInfo.codLanguage;
		recordInfo.symsgData.codMsg = SystemCode.EMP_MAT_NOT_FOUND;
		
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
