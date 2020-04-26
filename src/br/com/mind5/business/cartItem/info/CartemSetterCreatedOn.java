package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartemSetterCreatedOn extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
