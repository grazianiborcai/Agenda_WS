package br.com.mind5.business.storeSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SotarchMergerToSelect extends InfoMergerTemplate<SotarchInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor<SotarchInfo, SotarchInfo> getVisitorHook() {
		return new SotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SotarchInfo> getUniquifierHook() {
		return new SotarchUniquifier();
	}
}
