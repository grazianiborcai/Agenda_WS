package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerCartCateg extends InfoMergerTemplate<CartemInfo, CartCategInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, CartCategInfo> getVisitorHook() {
		return new CartemVisiMergeCartCateg();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
