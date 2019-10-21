package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerStolis extends InfoMergerTemplate<CartemInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, StolisInfo> getVisitorHook() {
		return new CartemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
