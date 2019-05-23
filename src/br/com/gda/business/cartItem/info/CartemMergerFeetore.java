package br.com.gda.business.cartItem.info;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerFeetore extends InfoMergerTemplate<CartemInfo, FeetoreInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, FeetoreInfo> getVisitorHook() {
		return new CartemVisiMergeFeetore();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
