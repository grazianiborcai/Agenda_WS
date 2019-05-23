package br.com.gda.business.cartItem.info;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerTotAmount extends InfoMergerTemplate<CartemInfo, TotAmountInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, TotAmountInfo> getVisitorHook() {
		return new CartemVisiMergeTotAmount();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
