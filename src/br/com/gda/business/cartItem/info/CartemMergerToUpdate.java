package br.com.gda.business.cartItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerToUpdate extends InfoMergerTemplate<CartemInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, CartemInfo> getVisitorHook() {
		return new CartemVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
