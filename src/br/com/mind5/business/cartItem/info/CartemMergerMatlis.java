package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerMatlis extends InfoMergerTemplate<CartemInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, MatlisInfo> getVisitorHook() {
		return new CartemVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
