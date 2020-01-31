package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemarchMergerToSelect extends InfoMergerTemplate_<CartemarchInfo, CartemarchInfo> {

	@Override protected InfoMergerVisitor_<CartemarchInfo, CartemarchInfo> getVisitorHook() {
		return new CartemarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartemarchInfo> getUniquifierHook() {
		return new CartemarchUniquifier();
	}
}
