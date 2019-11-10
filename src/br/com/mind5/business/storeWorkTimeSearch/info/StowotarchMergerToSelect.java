package br.com.mind5.business.storeWorkTimeSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotarchMergerToSelect extends InfoMergerTemplate<StowotarchInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor<StowotarchInfo, StowotarchInfo> getVisitorHook() {
		return new StowotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StowotarchInfo> getUniquifierHook() {
		return new StowotarchUniquifier();
	}
}
