package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartemSetterAged extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {
		recordInfo.isAged = true;
		return recordInfo;
	}
}
