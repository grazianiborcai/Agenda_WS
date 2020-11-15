package br.com.mind5.business.cart.info;

import br.com.mind5.common.TimeAge;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterExpiryOn extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		recordInfo.expiryOn = new TimeAge().getNowMinusOffset();
		return recordInfo;
	}
}
