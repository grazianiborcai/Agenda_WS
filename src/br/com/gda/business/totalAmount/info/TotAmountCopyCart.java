package br.com.gda.business.totalAmount.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;

final class TotAmountCopyCart extends InfoCopierTemplate<TotAmountInfo, CartInfo>{
	
	public TotAmountCopyCart() {
		super();
	}
	
	
	
	@Override protected TotAmountInfo makeCopyHook(CartInfo source) {
		TotAmountInfo result = new TotAmountInfo();
			
		result.amount = source.price;	
		result.codCurr = source.codCurr;
		return result;
	}
}
