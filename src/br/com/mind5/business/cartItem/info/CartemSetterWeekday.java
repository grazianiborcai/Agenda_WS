package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartemSetterWeekday extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
