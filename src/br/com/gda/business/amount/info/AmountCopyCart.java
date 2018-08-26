package br.com.gda.business.amount.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AmountCopyCart extends InfoCopierTemplate<AmountInfo, CartInfo>{
	
	public AmountCopyCart() {
		super();
	}
	
	
	
	@Override protected AmountInfo makeCopyHook(CartInfo source) {
		AmountInfo result = new AmountInfo();
			
		result.amount = source.price;	
		result.codCurr = source.codCurr;
		return result;
	}
}
