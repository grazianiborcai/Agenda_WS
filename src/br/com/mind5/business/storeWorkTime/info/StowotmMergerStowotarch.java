package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotmMergerStowotarch extends InfoMergerTemplate_<StowotmInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor_<StowotmInfo, StowotarchInfo> getVisitorHook() {
		return new StowotmVisiMergeStowotarch();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
