package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmMergerStolis extends InfoMergerTemplate<StowotmInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StolisInfo> getVisitorHook() {
		return new StowotmVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
