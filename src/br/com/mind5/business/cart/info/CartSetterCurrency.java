package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterCurrency extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		recordInfo.codCurr = "BRL";
		return recordInfo;
	}	
}
