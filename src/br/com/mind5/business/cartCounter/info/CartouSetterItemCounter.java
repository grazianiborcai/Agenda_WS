package br.com.mind5.business.cartCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartouSetterItemCounter extends InfoSetterTemplate<CartouInfo> {
	
	@Override protected CartouInfo setAttrHook(CartouInfo recordInfo) {
		if (recordInfo.cartems == null)
			return setZeroItem(recordInfo);
		
		if (recordInfo.cartems.isEmpty())
			return setZeroItem(recordInfo);
		
		return setTotItem(recordInfo);
	}
	
	
	
	private CartouInfo setZeroItem(CartouInfo recordInfo) {
		recordInfo.itemCounter = 0;
		return recordInfo;
	}
	
	
	
	private CartouInfo setTotItem(CartouInfo recordInfo) {
		recordInfo.itemCounter = recordInfo.cartems.size();	
		return recordInfo;
	}
}
