package br.com.gda.business.storeWorkTime.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StowotmMergerStolis extends InfoMergerTemplate<StowotmInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StolisInfo> getVisitorHook() {
		return new StowotmVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
