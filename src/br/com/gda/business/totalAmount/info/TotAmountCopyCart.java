package br.com.gda.business.totalAmount.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class TotAmountCopyCart extends InfoCopierTemplate<TotAmountInfo, CartemInfo>{
	
	public TotAmountCopyCart() {
		super();
	}
	
	
	
	@Override protected TotAmountInfo makeCopyHook(CartemInfo source) {
		TotAmountInfo result = new TotAmountInfo();
			
		result.amount = source.price;	
		result.codCurr = source.codCurr;
		return result;
	}
}
