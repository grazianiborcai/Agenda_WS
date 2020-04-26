package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.TotAmount;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartemSetterTotitem extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {
		TotAmount totAmount = new TotAmount();
		recordInfo.totitem = totAmount.computeTotalItem(recordInfo.price, recordInfo.quantity);
		
		return recordInfo;
	}	
}
