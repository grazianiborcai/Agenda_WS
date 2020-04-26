package br.com.mind5.business.cart.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterLChanged extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
