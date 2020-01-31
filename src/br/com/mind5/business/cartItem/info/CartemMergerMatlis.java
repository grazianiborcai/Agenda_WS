package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerMatlis extends InfoMergerTemplate_<CartemInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, MatlisInfo> getVisitorHook() {
		return new CartemVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
