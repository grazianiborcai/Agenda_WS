package br.com.gda.business.cartReserve.info;

import java.time.LocalDateTime;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class CarterveSetterLChanged implements InfoSetter<CarterveInfo> {
	private long TIME_SPAN = 15;
	
	
	public CarterveInfo setAttr(CarterveInfo recordInfo) {
		checkArgument(recordInfo);
		return setLChanged(recordInfo);
	}
	
	
	
	private CarterveInfo setLChanged(CarterveInfo recordInfo) {
		LocalDateTime now = genLastChanged();			
		recordInfo.lastChanged = shiftTime(now);	
		
		return recordInfo;
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.localDateTimeNow();
	}
	
	
	
	private LocalDateTime shiftTime(LocalDateTime now) {
		return now.minusMinutes(TIME_SPAN);
	}
	
	
	
	private void checkArgument(CarterveInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
