package br.com.gda.business.cartItem.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerMat extends InfoMergerTemplate<CartemInfo, MatInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, MatInfo> getVisitorHook() {
		return new CartemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
