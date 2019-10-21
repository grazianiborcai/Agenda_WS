package br.com.mind5.business.storeLeaveDateSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolarchMergerToSelect extends InfoMergerTemplate<StolarchInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor<StolarchInfo, StolarchInfo> getVisitorHook() {
		return new StolarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolarchInfo> getUniquifierHook() {
		return new StolarchUniquifier();
	}
}
