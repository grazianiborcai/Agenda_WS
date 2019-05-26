package br.com.gda.business.cartItem.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerStolis extends InfoMergerTemplate<CartemInfo, StolisInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, StolisInfo> getVisitorHook() {
		return new CartemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
