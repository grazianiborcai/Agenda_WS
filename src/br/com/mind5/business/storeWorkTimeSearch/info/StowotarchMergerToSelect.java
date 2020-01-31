package br.com.mind5.business.storeWorkTimeSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotarchMergerToSelect extends InfoMergerTemplate_<StowotarchInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor_<StowotarchInfo, StowotarchInfo> getVisitorHook() {
		return new StowotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StowotarchInfo> getUniquifierHook() {
		return new StowotarchUniquifier();
	}
}
