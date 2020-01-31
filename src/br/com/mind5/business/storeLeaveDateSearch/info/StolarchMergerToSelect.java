package br.com.mind5.business.storeLeaveDateSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolarchMergerToSelect extends InfoMergerTemplate_<StolarchInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor_<StolarchInfo, StolarchInfo> getVisitorHook() {
		return new StolarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolarchInfo> getUniquifierHook() {
		return new StolarchUniquifier();
	}
}
