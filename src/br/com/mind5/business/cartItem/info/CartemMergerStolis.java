package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerStolis extends InfoMergerTemplate_<CartemInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, StolisInfo> getVisitorHook() {
		return new CartemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
