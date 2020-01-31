package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotmMergerStolis extends InfoMergerTemplate_<StowotmInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<StowotmInfo, StolisInfo> getVisitorHook() {
		return new StowotmVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
