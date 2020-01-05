package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerCartemarch extends InfoMergerTemplate<CartemInfo, CartemarchInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, CartemarchInfo> getVisitorHook() {
		return new CartemVisiMergeCartemarch();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
