package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.SystemCode;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class CartemSetterSymsgL01 extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {		
		recordInfo.symsgData = new SymsgInfo();
		
		recordInfo.symsgData.codLanguage = recordInfo.codLanguage;
		recordInfo.symsgData.codMsg = SystemCode.CART_ITEM_AGED_DATE;
		
		return recordInfo;
	}
}
