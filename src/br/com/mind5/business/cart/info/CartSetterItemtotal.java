package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.TotAmount;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterItemtotal extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		TotAmount totAmount = new TotAmount();
		int counter = 0;
		
		for (CartemInfo eachCartem : recordInfo.cartems) {
			if (counter == 0) {
				recordInfo.itemTotal = eachCartem.totitem;
			} else {
				recordInfo.itemTotal = totAmount.computeTotal(recordInfo.itemTotal, eachCartem.totitem);
			}
			
			counter = counter + 1;
		}
		
		return recordInfo;
	}
}
