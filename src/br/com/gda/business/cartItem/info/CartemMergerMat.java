package br.com.gda.business.cartItem.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerMat extends InfoMergerTemplate<CartemInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, MatInfo> getVisitorHook() {
		return new CartemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
