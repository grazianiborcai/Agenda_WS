package br.com.mind5.business.cart.info;

import br.com.mind5.common.TotAmount;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterGrantotal extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		TotAmount totAmount = new TotAmount();		
		recordInfo.grandTotal = totAmount.computeTotal(recordInfo.itemTotal, recordInfo.feeService);		
		return recordInfo;
	}
}
