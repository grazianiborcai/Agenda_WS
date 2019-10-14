package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolateMergerStolis extends InfoMergerTemplate<StolateInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolisInfo> getVisitorHook() {
		return new StolateVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
