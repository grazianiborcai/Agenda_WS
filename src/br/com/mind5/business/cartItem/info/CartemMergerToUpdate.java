package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerToUpdate extends InfoMergerTemplate<CartemInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, CartemInfo> getVisitorHook() {
		return new CartemVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
