package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerToSelect extends InfoMergerTemplate<CartemInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, CartemInfo> getVisitorHook() {
		return new CartemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
