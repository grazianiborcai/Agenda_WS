package br.com.mind5.business.cartItem.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CartemSetterCreatedOn implements InfoSetter<CartemInfo> {
	
	public CartemInfo setAttr(CartemInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = genCreatedOn();
		return recordInfo;
	}
	
	
	
	private void checkArgument(CartemInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genCreatedOn() {
		return DefaultValue.localDateTimeNow();
	}
}
