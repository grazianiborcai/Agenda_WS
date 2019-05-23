package br.com.gda.business.cartItem.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerStore extends InfoMergerTemplate<CartemInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, StoreInfo> getVisitorHook() {
		return new CartemVisiMergeStore();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
