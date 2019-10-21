package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerMatore extends InfoMergerTemplate<CartemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, MatoreInfo> getVisitorHook() {
		return new CartemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
