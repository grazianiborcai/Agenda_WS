package br.com.mind5.business.cartCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartouSetterCartem extends InfoSetterTemplate<CartouInfo> {
	
	@Override protected CartouInfo setAttrHook(CartouInfo recordInfo) {
		recordInfo.cartems = null;
		return recordInfo;
	}
}
