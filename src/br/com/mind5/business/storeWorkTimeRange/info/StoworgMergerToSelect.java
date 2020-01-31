package br.com.mind5.business.storeWorkTimeRange.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoworgMergerToSelect extends InfoMergerTemplate_<StoworgInfo, StoworgInfo> {

	@Override protected InfoMergerVisitor_<StoworgInfo, StoworgInfo> getVisitorHook() {
		return new StoworgVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoworgInfo> getUniquifierHook() {
		return new StoworgUniquifier();
	}
}
