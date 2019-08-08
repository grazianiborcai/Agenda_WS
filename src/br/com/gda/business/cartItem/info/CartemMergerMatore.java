package br.com.gda.business.cartItem.info;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerMatore extends InfoMergerTemplate<CartemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, MatoreInfo> getVisitorHook() {
		return new CartemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
