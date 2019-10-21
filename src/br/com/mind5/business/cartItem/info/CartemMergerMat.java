package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerMat extends InfoMergerTemplate<CartemInfo, MatInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, MatInfo> getVisitorHook() {
		return new CartemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
