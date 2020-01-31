package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerMatore extends InfoMergerTemplate_<CartemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, MatoreInfo> getVisitorHook() {
		return new CartemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
