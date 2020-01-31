package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerCartemarch extends InfoMergerTemplate_<CartemInfo, CartemarchInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, CartemarchInfo> getVisitorHook() {
		return new CartemVisiMergeCartemarch();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
