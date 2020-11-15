package br.com.mind5.business.cartReserve.info;

import br.com.mind5.common.TimeAge;
import br.com.mind5.info.InfoSetterTemplate;

public final class CarterveSetterLChanged extends InfoSetterTemplate<CarterveInfo> {

	@Override protected CarterveInfo setAttrHook(CarterveInfo recordInfo) {		
		recordInfo.lastChanged = new TimeAge().getNowMinusOffset();		
		return recordInfo;
	}
}
