package br.com.gda.business.storeLeaveDateSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolarchMergerToSelect extends InfoMergerTemplate<StolarchInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor<StolarchInfo, StolarchInfo> getVisitorHook() {
		return new StolarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolarchInfo> getUniquifierHook() {
		return new StolarchUniquifier();
	}
}
