package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerToUpdate extends InfoMergerTemplate_<CartemInfo, CartemInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, CartemInfo> getVisitorHook() {
		return new CartemVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
