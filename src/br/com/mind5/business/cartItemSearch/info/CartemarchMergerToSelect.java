package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemarchMergerToSelect extends InfoMergerTemplate<CartemarchInfo, CartemarchInfo> {

	@Override protected InfoMergerVisitor<CartemarchInfo, CartemarchInfo> getVisitorHook() {
		return new CartemarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartemarchInfo> getUniquifierHook() {
		return new CartemarchUniquifier();
	}
}
