package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolateMergerStolis extends InfoMergerTemplate<StolateInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolisInfo> getVisitorHook() {
		return new StolateVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
