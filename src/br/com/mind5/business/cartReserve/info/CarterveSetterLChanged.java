package br.com.mind5.business.cartReserve.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CarterveSetterLChanged extends InfoSetterTemplate<CarterveInfo> {
	private long TIME_SPAN = 15;
	
	
	@Override protected CarterveInfo setAttrHook(CarterveInfo recordInfo) {
		LocalDateTime now = DefaultValue.localDateTimeNow();			
		recordInfo.lastChanged = shiftTime(now);	
		
		return recordInfo;
	}
	
	
	
	private LocalDateTime shiftTime(LocalDateTime now) {
		return now.minusMinutes(TIME_SPAN);
	}
}
