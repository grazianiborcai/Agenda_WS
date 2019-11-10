package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmMergerStowotarch extends InfoMergerTemplate<StowotmInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StowotarchInfo> getVisitorHook() {
		return new StowotmVisiMergeStowotarch();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
