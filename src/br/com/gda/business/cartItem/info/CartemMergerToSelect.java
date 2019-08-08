package br.com.gda.business.cartItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerToSelect extends InfoMergerTemplate<CartemInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, CartemInfo> getVisitorHook() {
		return new CartemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
