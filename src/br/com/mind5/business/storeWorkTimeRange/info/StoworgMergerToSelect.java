package br.com.mind5.business.storeWorkTimeRange.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoworgMergerToSelect extends InfoMergerTemplate<StoworgInfo, StoworgInfo> {

	@Override protected InfoMergerVisitor<StoworgInfo, StoworgInfo> getVisitorHook() {
		return new StoworgVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoworgInfo> getUniquifierHook() {
		return new StoworgUniquifier();
	}
}
